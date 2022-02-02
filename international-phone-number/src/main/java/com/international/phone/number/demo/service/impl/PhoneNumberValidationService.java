package com.international.phone.number.demo.service.impl;

import com.international.phone.number.demo.exception.CountryNotFoundException;
import com.international.phone.number.demo.model.response.PhoneNumberValidationResponse;
import com.international.phone.number.demo.model.response.PhoneNumberValidationResult;
import com.international.phone.number.demo.repo.result.CustomerPhoneNumber;
import com.international.phone.number.demo.service.dto.InternationalPhoneNumberDTO;
import com.international.phone.number.demo.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author HowaydaGamal
 * @created 1/26/2022
 */

@Service
@Slf4j
public class PhoneNumberValidationService {

    private final CustomerService customerService;

    private final InternationalPhoneNumberService internationalPhoneNumberService;

    public PhoneNumberValidationService(CustomerService customerService, InternationalPhoneNumberService internationalPhoneNumberService) {
        this.customerService = customerService;
        this.internationalPhoneNumberService = internationalPhoneNumberService;
    }

    public PhoneNumberValidationResponse validateAllCustomersPhoneNumbers() {

        log.info("Start validateAllCustomersPhoneNumbers");
        List<CustomerPhoneNumber> customerPhoneNumbers = customerService.findAllCustomersPhoneNumbers();
        PhoneNumberValidationResponse phoneNumberValidationResponse = new PhoneNumberValidationResponse();
        customerPhoneNumbers.stream().forEach(customerPhoneNumber -> {
            try {
                phoneNumberValidationResponse.getPhoneNumberValidationResultList().add(validatePhoneNumber(customerPhoneNumber.getPhone()));
            } catch (CountryNotFoundException e) {
                log.error(e.getMessage() + "for phone number {}", customerPhoneNumber.getPhone());
            }
        });
        phoneNumberValidationResponse.setMessage(Constants.VALIDATION_SUCCESS_MESSAGE);
        phoneNumberValidationResponse.setStatusCode(Constants.SUCCESS_STATUS_CODE);
        return phoneNumberValidationResponse;
    }

    public PhoneNumberValidationResult validatePhoneNumber(final String phoneNumber) throws CountryNotFoundException {

        log.info("Start isValidPhoneNumber with phoneNumber {}", phoneNumber);
        List<InternationalPhoneNumberDTO> internationalPhoneNumberDTOList = internationalPhoneNumberService.findAll();
        String countryCode = phoneNumber.substring(phoneNumber.indexOf('(') + 1, phoneNumber.indexOf(')'));
        InternationalPhoneNumberDTO internationalPhoneNumberDTO = findInternationalPhoneNumberPerCountryCode(countryCode, internationalPhoneNumberDTOList);
        PhoneNumberValidationResult phoneNumberValidationResult = new PhoneNumberValidationResult();
        phoneNumberValidationResult.setValid(Boolean.FALSE);
        phoneNumberValidationResult.setNumber(phoneNumber);
        phoneNumberValidationResult.setCountry(internationalPhoneNumberDTO.getCountry());
        phoneNumberValidationResult.setCountryCode(internationalPhoneNumberDTO.getCountryCode());
        if (validatePhoneNumberAgainstCountryPattern(internationalPhoneNumberDTO.getPhoneNumberPattern(), phoneNumber)) {
            phoneNumberValidationResult.setValid(Boolean.TRUE);
        }
        return phoneNumberValidationResult;
    }

    public InternationalPhoneNumberDTO findInternationalPhoneNumberPerCountryCode(String countryCode, List<InternationalPhoneNumberDTO> internationalPhoneNumberDTOList) throws CountryNotFoundException {

        log.info("Start findInternationalPhoneNumberPerCountryCode with countryCode {}", countryCode);
        for (InternationalPhoneNumberDTO internationalPhoneNumberDTO : internationalPhoneNumberDTOList) {
            if (internationalPhoneNumberDTO.getCountryCode().contains(countryCode))
                return internationalPhoneNumberDTO;
        }
        throw new CountryNotFoundException("No country configuration founded for country code " + countryCode);
    }

    public boolean validatePhoneNumberAgainstCountryPattern(String phoneNumberPattern, String phoneNumber) {

        return Pattern.matches(phoneNumberPattern, phoneNumber);
    }
}
