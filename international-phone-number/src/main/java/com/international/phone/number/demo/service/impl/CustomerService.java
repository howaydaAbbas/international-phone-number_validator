package com.international.phone.number.demo.service.impl;

import com.international.phone.number.demo.repo.CustomerRepository;
import com.international.phone.number.demo.repo.result.CustomerPhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HowaydaGamal
 * @created 1/26/2022
 */

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerPhoneNumber> findAllCustomersPhoneNumbers() {
        log.info("Start findAllCustomersPhoneNumbers");
        return customerRepository.findPhone();
    }
}
