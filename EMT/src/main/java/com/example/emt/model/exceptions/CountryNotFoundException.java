package com.example.emt.model.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Long id) {
        super(String.format("Country with the id: %d couldn't be found", id));
    }
}
