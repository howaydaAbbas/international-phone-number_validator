package com.international.phone.number.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author HowaydaGamal
 * @created 1/25/2022
 */

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    int id;

    String name;

    String phone;
}
