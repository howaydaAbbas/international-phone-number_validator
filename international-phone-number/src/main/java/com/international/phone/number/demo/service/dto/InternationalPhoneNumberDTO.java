package com.international.phone.number.demo.service.dto;

import com.international.phone.number.demo.model.InternationalPhoneNumber;
import lombok.Data;

/**
 * @author HowaydaGamal
 * @created 1/25/2022
 */

@Data
public class InternationalPhoneNumberDTO {

    private String country;

    private String countryCode;

    private String phoneNumberPattern;

    public static final InternationalPhoneNumberDTO map(InternationalPhoneNumber internationalPhoneNumber) {
        InternationalPhoneNumberDTO internationalPhoneNumberDTO = new InternationalPhoneNumberDTO();
        internationalPhoneNumberDTO.setCountry(internationalPhoneNumber.getCountry());
        internationalPhoneNumberDTO.setCountryCode(internationalPhoneNumber.getCountryCode());
        internationalPhoneNumberDTO.setPhoneNumberPattern(internationalPhoneNumber.getPhoneNumberPattern());
        return internationalPhoneNumberDTO;
    }
}
