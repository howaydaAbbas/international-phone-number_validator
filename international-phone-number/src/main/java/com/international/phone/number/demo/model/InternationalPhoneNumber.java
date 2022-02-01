package com.international.phone.number.demo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author HowaydaGamal
 * @created 1/25/2022
 */

@Data
@Entity
@Table(name = "international_phone_number")
public class InternationalPhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String country;

    private String countryCode;

    private String phoneNumberPattern;
}
