package com.example.emt.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with the id: %d couldn't be found", id));
    }
}
