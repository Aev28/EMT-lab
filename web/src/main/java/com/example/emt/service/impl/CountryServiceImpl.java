package com.example.emt.service.impl;

import com.example.emt.model.Country;
import com.example.emt.model.DTO.CountryDTO;
import com.example.emt.model.exceptions.CountryNotFoundException;
import com.example.emt.repository.CountryRepository;
import com.example.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name, continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> save(CountryDTO countryDTO) {
        Country country = new Country(countryDTO.getName(), countryDTO.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, CountryDTO countryDTO) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(countryDTO.getName());
        country.setContinent(countryDTO.getContinent());
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
