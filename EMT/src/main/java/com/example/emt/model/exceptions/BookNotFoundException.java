package com.example.emt.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book with the id: %d couldn't be found", id));
    }
}
