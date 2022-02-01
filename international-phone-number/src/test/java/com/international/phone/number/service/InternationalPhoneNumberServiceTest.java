package com.international.phone.number.service;

import com.international.phone.number.demo.repo.InternationalPhoneNumberRepository;
import com.international.phone.number.demo.service.dto.InternationalPhoneNumberDTO;
import com.international.phone.number.demo.service.impl.InternationalPhoneNumberService;
import com.international.phone.number.utils.GenerateStubs;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.times;

/**
 * @author HowaydaGamal
 * @created 1/29/2022
 */

@RunWith(SpringRunner.class)
public class InternationalPhoneNumberServiceTest {

    @Mock
    InternationalPhoneNumberRepository internationalPhoneNumberRepository;

    @InjectMocks
    InternationalPhoneNumberService internationalPhoneNumberService;

    @Test
    public void findAllSuccessTest() {

        Mockito.when(internationalPhoneNumberRepository.findAll()).thenReturn(GenerateStubs.generateInternationalPhoneNumberList());
        List<InternationalPhoneNumberDTO> internationalPhoneNumberDTOList = internationalPhoneNumberService.findAll();
        Assertions.assertNotNull(internationalPhoneNumberDTOList);
        Mockito.verify(internationalPhoneNumberRepository, times(1)).findAll();
    }
}
