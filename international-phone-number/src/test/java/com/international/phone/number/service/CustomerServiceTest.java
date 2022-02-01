package com.international.phone.number.service;

import com.international.phone.number.demo.repo.CustomerRepository;
import com.international.phone.number.demo.repo.result.CustomerPhoneNumber;
import com.international.phone.number.demo.service.impl.CustomerService;
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
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    public void findAllCustomersPhoneNumbersSuccessTest() {

        Mockito.when(customerRepository.findPhone()).thenReturn(GenerateStubs.generateCustomerPhoneNumbersList());
        List<CustomerPhoneNumber> customerPhoneNumberList = customerService.findAllCustomersPhoneNumbers();
        Assertions.assertNotNull(customerPhoneNumberList);
        Mockito.verify(customerRepository, times(1)).findPhone();
    }

}
