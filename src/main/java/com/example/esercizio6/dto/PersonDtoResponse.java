package com.example.esercizio6.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PersonDtoResponse {
    private UUID id;
    private String name;
    private String surname;
    private String profession;

    public PersonDtoResponse(UUID id,String name, String surname, String profession) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.profession = profession;
    }


}
