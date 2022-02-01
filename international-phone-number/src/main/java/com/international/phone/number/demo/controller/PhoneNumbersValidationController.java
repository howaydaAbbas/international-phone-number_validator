package com.international.phone.number.demo.controller;

import com.international.phone.number.demo.model.response.PhoneNumberValidationResponse;
import com.international.phone.number.demo.service.impl.PhoneNumberValidationService;
import com.international.phone.number.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HowaydaGamal
 * @created 1/26/2022
 */

@RequestMapping(value = "/validatePhoneNumbers")
@RestController
@Slf4j
@RequiredArgsConstructor
public class PhoneNumbersValidationController {

    private final PhoneNumberValidationService phoneNumberValidationService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<PhoneNumberValidationResponse> validatePhoneNumbers() {

        final PhoneNumberValidationResponse phoneNumberValidationResponse = phoneNumberValidationService.validateAllCustomersPhoneNumbers();
        if (Constants.SUCCESS_STATUS_CODE.equals(phoneNumberValidationResponse.getStatusCode())) {
            return ResponseEntity.status(HttpStatus.OK).body(phoneNumberValidationResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(phoneNumberValidationResponse);
    }
}

