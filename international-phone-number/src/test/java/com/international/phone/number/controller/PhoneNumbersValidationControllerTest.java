package com.international.phone.number.controller;

import com.international.phone.number.InternationalPhoneNumberApplication;
import com.international.phone.number.demo.model.response.PhoneNumberValidationResponse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HowaydaGamal
 * @created 1/28/2022
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InternationalPhoneNumberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhoneNumbersValidationControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void validatePhoneNumbersSuccessIT() {

        HttpEntity<PhoneNumberValidationResponse> entity = new HttpEntity<>(headers);
        ResponseEntity<PhoneNumberValidationResponse> response = restTemplate.exchange(
                establishPortAndURIPort("/api/validatePhoneNumbers"),
                HttpMethod.GET, entity, PhoneNumberValidationResponse.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertNotNull(response.getBody());
    }

    private String establishPortAndURIPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
