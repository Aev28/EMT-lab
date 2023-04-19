package com.example.emt.model.DTO;

import lombok.Data;

@Data
public class AuthorDTO {
    private String name;

    private String surname;

    private Long country;

    public AuthorDTO() {
    }

    public AuthorDTO(String name, String surname, Long country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
