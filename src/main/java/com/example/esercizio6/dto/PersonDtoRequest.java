package com.example.esercizio6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonDtoRequest {
    private String name;
    private String surname;
    private String profession;

    public PersonDtoRequest(@JsonProperty(value = "name",required = true) String name,
                            @JsonProperty(value = "surname",required = true) String surname,
                            @JsonProperty(value = "profession",required = true) String profession)
    {
        this.name = name;
        this.surname = surname;
        this.profession = profession;
    }
}
