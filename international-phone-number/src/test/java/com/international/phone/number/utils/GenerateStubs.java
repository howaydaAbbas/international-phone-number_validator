package com.international.phone.number.utils;

import com.international.phone.number.demo.model.InternationalPhoneNumber;
import com.international.phone.number.demo.model.response.PhoneNumberValidationResult;
import com.international.phone.number.demo.repo.result.CustomerPhoneNumber;
import com.international.phone.number.demo.service.dto.InternationalPhoneNumberDTO;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.ArrayList;
import java.util.List;

public class GenerateStubs {

    public static final String VALID_PHONE_NUMBER = "(212) 698054317";

    public static final String INVALID_PHONE_NUMBER = "(212) 6007989253";

    public static final String PHONE_VALIDATION_PATTERN = "\\(212\\)\\ ?[5-9]\\d{8}$";

    public static final String COUNTRY_CODE = "212";

    public static final String NOT_FOUND_COUNTRY_CODE = "200";

    public static List<CustomerPhoneNumber> generateCustomerPhoneNumbersList() {

        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        CustomerPhoneNumber customerPhoneNumber1 = factory.createProjection(CustomerPhoneNumber.class);
        customerPhoneNumber1.setPhone("(212) 6007989253");
        CustomerPhoneNumber customerPhoneNumber2 = factory.createProjection(CustomerPhoneNumber.class);
        customerPhoneNumber2.setPhone("(212) 698054317");
        List<CustomerPhoneNumber> customerPhoneNumberList = new ArrayList<>();
        customerPhoneNumberList.add(customerPhoneNumber1);
        customerPhoneNumberList.add(customerPhoneNumber2);
        return customerPhoneNumberList;
    }

    public static List<InternationalPhoneNumber> generateInternationalPhoneNumberList() {

        InternationalPhoneNumber internationalPhoneNumber1 = new InternationalPhoneNumber();
        internationalPhoneNumber1.setPhoneNumberPattern("\\(237\\)\\ ?[2368]\\d{7,8}$");
        internationalPhoneNumber1.setCountry("Cameroon");
        internationalPhoneNumber1.setCountryCode("+237");
        InternationalPhoneNumber internationalPhoneNumber2 = new InternationalPhoneNumber();
        internationalPhoneNumber2.setPhoneNumberPattern("\\(251\\)\\ ?[1-59]\\d{8}$");
        internationalPhoneNumber2.setCountry("Ethiopia");
        internationalPhoneNumber2.setCountryCode("+251");
        InternationalPhoneNumber internationalPhoneNumber3 = new InternationalPhoneNumber();
        internationalPhoneNumber3.setPhoneNumberPattern("\\(212\\)\\ ?[5-9]\\d{8}$");
        internationalPhoneNumber3.setCountry("Morocco");
        internationalPhoneNumber3.setCountryCode("+212");
        InternationalPhoneNumber internationalPhoneNumber4 = new InternationalPhoneNumber();
        internationalPhoneNumber4.setPhoneNumberPattern("\\(258\\)\\ ?[28]\\d{7,8}$");
        internationalPhoneNumber4.setCountry("Mozambique");
        internationalPhoneNumber4.setCountryCode("+258");
        InternationalPhoneNumber internationalPhoneNumber5 = new InternationalPhoneNumber();
        internationalPhoneNumber5.setPhoneNumberPattern("\\(256\\)\\ ?\\d{9}$");
        internationalPhoneNumber5.setCountry("Uganda");
        internationalPhoneNumber5.setCountryCode("+256");
        List<InternationalPhoneNumber> internationalPhoneNumberList = new ArrayList<>();
        internationalPhoneNumberList.add(internationalPhoneNumber1);
        internationalPhoneNumberList.add(internationalPhoneNumber2);
        internationalPhoneNumberList.add(internationalPhoneNumber3);
        internationalPhoneNumberList.add(internationalPhoneNumber4);
        internationalPhoneNumberList.add(internationalPhoneNumber5);
        return internationalPhoneNumberList;
    }

    public static List<InternationalPhoneNumberDTO> generateInternationalPhoneNumberDTOList() {

        InternationalPhoneNumberDTO internationalPhoneNumber1 = new InternationalPhoneNumberDTO();
        internationalPhoneNumber1.setPhoneNumberPattern("\\(237\\)\\ ?[2368]\\d{7,8}$");
        internationalPhoneNumber1.setCountry("Cameroon");
        internationalPhoneNumber1.setCountryCode("+237");
        InternationalPhoneNumberDTO internationalPhoneNumber2 = new InternationalPhoneNumberDTO();
        internationalPhoneNumber2.setPhoneNumberPattern("\\(251\\)\\ ?[1-59]\\d{8}$");
        internationalPhoneNumber2.setCountry("Ethiopia");
        internationalPhoneNumber2.setCountryCode("+251");
        InternationalPhoneNumberDTO internationalPhoneNumber3 = new InternationalPhoneNumberDTO();
        internationalPhoneNumber3.setPhoneNumberPattern("\\(212\\)\\ ?[5-9]\\d{8}$");
        internationalPhoneNumber3.setCountry("Morocco");
        internationalPhoneNumber3.setCountryCode("+212");
        InternationalPhoneNumberDTO internationalPhoneNumber4 = new InternationalPhoneNumberDTO();
        internationalPhoneNumber4.setPhoneNumberPattern("\\(258\\)\\ ?[28]\\d{7,8}$");
        internationalPhoneNumber4.setCountry("Mozambique");
        internationalPhoneNumber4.setCountryCode("+258");
        InternationalPhoneNumberDTO internationalPhoneNumber5 = new InternationalPhoneNumberDTO();
        internationalPhoneNumber5.setPhoneNumberPattern("\\(256\\)\\ ?\\d{9}$");
        internationalPhoneNumber5.setCountry("Uganda");
        internationalPhoneNumber5.setCountryCode("+256");
        List<InternationalPhoneNumberDTO> internationalPhoneNumberList = new ArrayList<>();
        internationalPhoneNumberList.add(internationalPhoneNumber1);
        internationalPhoneNumberList.add(internationalPhoneNumber2);
        internationalPhoneNumberList.add(internationalPhoneNumber3);
        internationalPhoneNumberList.add(internationalPhoneNumber4);
        internationalPhoneNumberList.add(internationalPhoneNumber5);
        return internationalPhoneNumberList;
    }

    public static InternationalPhoneNumberDTO generateInternationalPhoneNumberDTO() {
        InternationalPhoneNumberDTO internationalPhoneNumberDTO = new InternationalPhoneNumberDTO();
        internationalPhoneNumberDTO.setPhoneNumberPattern("\\(212\\)\\ ?[5-9]\\d{8}$");
        internationalPhoneNumberDTO.setCountry("Morocco");
        internationalPhoneNumberDTO.setCountryCode("+212");
        return internationalPhoneNumberDTO;
    }

    public static PhoneNumberValidationResult generatePhoneNumberValidationResult() {

        PhoneNumberValidationResult phoneNumberValidationResult = new PhoneNumberValidationResult();
        phoneNumberValidationResult.setValid(Boolean.TRUE);
        phoneNumberValidationResult.setNumber(VALID_PHONE_NUMBER);
        phoneNumberValidationResult.setCountry("Morocco");
        phoneNumberValidationResult.setCountryCode("+212");
        return phoneNumberValidationResult;
    }
}
