package com.international.phone.number.demo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HowaydaGamal
 * @created 1/29/2022
 */

@Data
public class PhoneNumberValidationResponse {

    public PhoneNumberValidationResponse(){
        this.phoneNumberValidationResultList = new ArrayList<>();
    }

    String statusCode;

    String message;

    @JsonProperty(value = "phoneNumberValidationResult", required = true)
    private List<PhoneNumberValidationResult> phoneNumberValidationResultList ;
}
