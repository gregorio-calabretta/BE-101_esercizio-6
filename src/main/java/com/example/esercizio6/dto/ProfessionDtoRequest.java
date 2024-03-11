package com.example.esercizio6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProfessionDtoRequest {
    private Integer id;
    private String name;

    public ProfessionDtoRequest(@JsonProperty("id") Integer id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
