package com.example.emt.service;

import com.example.emt.model.Author;
import com.example.emt.model.DTO.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long authorId);

    Optional<Author> save(String name, String surname, Long countryId);

    Optional<Author> save(AuthorDTO authorDTO);

    Optional<Author> edit(Long authorId, String name, String surname, Long countryId);

    Optional<Author> edit(Long id, AuthorDTO authorDTO);

    void deleteById(Long id);
}
