package com.example.emt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class NotAllowedToRentException extends RuntimeException{
    public NotAllowedToRentException(Long id) {
        super(String.format("The book with id: %d could not be rented (0 available copies)", id));
    }
}
