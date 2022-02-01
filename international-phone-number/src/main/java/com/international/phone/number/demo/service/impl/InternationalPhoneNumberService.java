package com.international.phone.number.demo.service.impl;

import com.international.phone.number.demo.repo.InternationalPhoneNumberRepository;
import com.international.phone.number.demo.service.dto.InternationalPhoneNumberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HowaydaGamal
 * @created 1/26/2022
 */

@Service
@Slf4j
public class InternationalPhoneNumberService {

    private final InternationalPhoneNumberRepository internationalPhoneNumberRepository;

    public InternationalPhoneNumberService(InternationalPhoneNumberRepository internationalPhoneNumberRepository) {
        this.internationalPhoneNumberRepository = internationalPhoneNumberRepository;
    }

    @Cacheable(value = "allInternationalPhoneNumbers")
    public List<InternationalPhoneNumberDTO> findAll() {

        return internationalPhoneNumberRepository.findAll().stream().map(internationalPhoneNumber -> InternationalPhoneNumberDTO.map(internationalPhoneNumber)).collect(Collectors.toList());
    }
}
