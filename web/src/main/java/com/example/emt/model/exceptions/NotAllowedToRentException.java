package com.example.emt.model.exceptions;

public class NotAllowedToRentException extends RuntimeException{
    public NotAllowedToRentException(Long id) {
        super(String.format("The book with id: %d could not be rented (0 available copies)", id));
    }
}
