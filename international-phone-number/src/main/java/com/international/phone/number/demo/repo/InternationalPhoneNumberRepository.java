package com.international.phone.number.demo.repo;

import com.international.phone.number.demo.model.InternationalPhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HowaydaGamal
 * @created 1/26/2022
 */

@Repository
public interface InternationalPhoneNumberRepository extends JpaRepository<InternationalPhoneNumber, Integer> {
}
