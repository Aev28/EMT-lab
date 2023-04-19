package com.example.emt.service.impl;

import com.example.emt.model.Author;
import com.example.emt.model.Country;
import com.example.emt.model.DTO.AuthorDTO;
import com.example.emt.model.exceptions.AuthorNotFoundException;
import com.example.emt.model.exceptions.CountryNotFoundException;
import com.example.emt.repository.AuthorRepository;
import com.example.emt.repository.CountryRepository;
import com.example.emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long authorId) {
        return this.authorRepository.findById(authorId);
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));
        for (Country searchCountry : this.countryRepository.findAll()) {
            if(searchCountry.equals(country)){
                country = searchCountry;
            }
        }
        Author author = new Author(name, surname, country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> save(AuthorDTO authorDTO) {
        Country country = this.countryRepository.findById(authorDTO.getCountry())
                .orElseThrow(() -> new CountryNotFoundException(authorDTO.getCountry()));
        Author author = new Author(authorDTO.getName(), authorDTO.getSurname(), country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long authorId, String name, String surname, Long countryId) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDTO authorDTO) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        Country country = this.countryRepository.findById(authorDTO.getCountry())
                .orElseThrow(() -> new CountryNotFoundException(authorDTO.getCountry()));
        author.setName(authorDTO.getName());
        author.setSurname(author.getSurname());
        author.setCountry(country);
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
