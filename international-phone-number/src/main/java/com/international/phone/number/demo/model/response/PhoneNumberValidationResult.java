package com.international.phone.number.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HowaydaGamal
 * @created 1/26/2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberValidationResult {

    private String number;

    private boolean valid;

    private String country;

    private String countryCode;
}
