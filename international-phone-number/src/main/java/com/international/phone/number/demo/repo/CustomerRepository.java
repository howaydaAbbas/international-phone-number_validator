package com.international.phone.number.demo.repo;

import com.international.phone.number.demo.model.Customer;
import com.international.phone.number.demo.repo.result.CustomerPhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HowaydaGamal
 * @created 1/26/2022
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select cust.phone as phone from Customer cust")
    List<CustomerPhoneNumber> findPhone();
}
