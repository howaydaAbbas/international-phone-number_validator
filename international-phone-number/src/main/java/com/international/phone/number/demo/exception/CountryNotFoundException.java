package com.international.phone.number.demo.exception;

public class CountryNotFoundException extends Exception{

    public CountryNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
