package com.example.esercizio6.mapper;

import com.example.esercizio6.dto.ProfessionDtoResponse;
import com.example.esercizio6.model.Profession;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProfessionMapper {
    public ProfessionDtoResponse map(Profession profession){
        return new ProfessionDtoResponse(profession.getId(), profession.getName());
    }


    public List<ProfessionDtoResponse> mapAll(List<Profession> professions){
        List<ProfessionDtoResponse> dtos = new LinkedList<>();

        for(Profession profession : professions){
            dtos.add(new ProfessionDtoResponse((profession.getId()), profession.getName()));
        }
        return dtos;
    }
}
