package com.example.esercizio6.mapper;

import com.example.esercizio6.dto.PersonDtoResponse;
import org.springframework.stereotype.Component;
import com.example.esercizio6.model.Person;

import java.util.LinkedList;
import java.util.List;


@Component
public class PersonMapper {
    public PersonDtoResponse map(Person person) {
        return new PersonDtoResponse(person.getId(),person.getName(), person.getSurname(), person.getProfession().getName());
    }

    public List<PersonDtoResponse> mapAll(List<Person> persons) {
        List<PersonDtoResponse> dtos = new LinkedList<>();

        for(Person person : persons) {
            dtos.add(new PersonDtoResponse(person.getId(),person.getName(), person.getSurname(), person.getProfession().getName()));
        }
        return  dtos;
    }
}
