package com.international.phone.number.service;

import com.international.phone.number.demo.exception.CountryNotFoundException;
import com.international.phone.number.demo.model.response.PhoneNumberValidationResponse;
import com.international.phone.number.demo.model.response.PhoneNumberValidationResult;
import com.international.phone.number.demo.service.dto.InternationalPhoneNumberDTO;
import com.international.phone.number.demo.service.impl.CustomerService;
import com.international.phone.number.demo.service.impl.InternationalPhoneNumberService;
import com.international.phone.number.demo.service.impl.PhoneNumberValidationService;
import com.international.phone.number.demo.utils.Constants;
import com.international.phone.number.utils.GenerateStubs;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static com.international.phone.number.utils.GenerateStubs.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * @author HowaydaGamal
 * @created 1/30/2022
 */

@RunWith(SpringRunner.class)
public class PhoneNumberValidationServiceTest {

    @Mock
    CustomerService customerService;

    @Mock
    InternationalPhoneNumberService internationalPhoneNumberService;

    @InjectMocks
    PhoneNumberValidationService phoneNumberValidationService;

    @Test
    public void validateAllCustomersPhoneNumbersSuccessTest() {
        Mockito.when(customerService.findAllCustomersPhoneNumbers()).thenReturn(GenerateStubs.generateCustomerPhoneNumbersList());
        PhoneNumberValidationResponse response = phoneNumberValidationService.validateAllCustomersPhoneNumbers();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getStatusCode(), Constants.SUCCESS_STATUS_CODE);
    }

    @Test
    public void givenValidPhoneNumberThenReturnValidResponse() throws CountryNotFoundException {
        Mockito.when(internationalPhoneNumberService.findAll()).thenReturn(generateInternationalPhoneNumberDTOList());
        PhoneNumberValidationResult phoneNumberValidationResult = phoneNumberValidationService.isValidPhoneNumber(VALID_PHONE_NUMBER);
        Assertions.assertEquals(generatePhoneNumberValidationResult().getNumber(), phoneNumberValidationResult.getNumber());
        Assertions.assertTrue(phoneNumberValidationResult.isValid());
    }

    @Test
    public void givenInvalidPhoneNumberThenReturnInvalidResponse() throws CountryNotFoundException {
        Mockito.when(internationalPhoneNumberService.findAll()).thenReturn(generateInternationalPhoneNumberDTOList());
        PhoneNumberValidationResult phoneNumberValidationResult = phoneNumberValidationService.isValidPhoneNumber(INVALID_PHONE_NUMBER);
        Assertions.assertFalse(phoneNumberValidationResult.isValid());
    }

    @Test
    public void givenCountryCodeThenReturnInternationalPhoneNumber() throws CountryNotFoundException {
        InternationalPhoneNumberDTO internationalPhoneNumberDTO = phoneNumberValidationService.findInternationalPhoneNumberPerCountryCode(COUNTRY_CODE, generateInternationalPhoneNumberDTOList());
        Assertions.assertEquals(internationalPhoneNumberDTO.getCountryCode(), generateInternationalPhoneNumberDTO().getCountryCode());
    }

    @Test
    public void givenNotFoundCountryCodeThenThrowException() {
        assertThatThrownBy(() -> phoneNumberValidationService.findInternationalPhoneNumberPerCountryCode(NOT_FOUND_COUNTRY_CODE, generateInternationalPhoneNumberDTOList())).isInstanceOf(CountryNotFoundException.class);
    }

    @Test
    public void givenValidPhoneNumberThenReturnTrue() {
        Assertions.assertTrue(phoneNumberValidationService.validatePhoneNumberAgainstCountryPattern(PHONE_VALIDATION_PATTERN, VALID_PHONE_NUMBER));
    }

    @Test
    public void givenInvalidPhoneNumberThenReturnFalse() {
        Assertions.assertFalse(phoneNumberValidationService.validatePhoneNumberAgainstCountryPattern(PHONE_VALIDATION_PATTERN, INVALID_PHONE_NUMBER));
    }
}
