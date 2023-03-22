package com.example.emt.service;

import com.example.emt.model.Country;
import com.example.emt.model.DTO.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    Optional<Country> save(CountryDTO countryDTO);

    Optional<Country> edit(Long id, String name, String continent);

    Optional<Country> edit(Long id, CountryDTO countryDTO);

    void deleteById(Long id);
}
