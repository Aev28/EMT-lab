package com.example.emt.model.DTO;

import lombok.Data;

@Data
public class CountryDTO {

    private String name;

    private String continent;

    public CountryDTO() {
    }

    public CountryDTO(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
