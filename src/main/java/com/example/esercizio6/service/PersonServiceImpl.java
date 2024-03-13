package com.example.esercizio6.service;

import com.example.esercizio6.exception.ApiExceptionHandler;
import com.example.esercizio6.exception.InvalidInputException;
import com.example.esercizio6.exception.ResourceNotFoundException;
import com.example.esercizio6.mapper.PersonMapper;
import com.example.esercizio6.dto.PersonDtoRequest;
import com.example.esercizio6.dto.PersonDtoResponse;
import com.example.esercizio6.model.Profession;
import com.example.esercizio6.repository.PersonRepository;
import com.example.esercizio6.model.Person;
import com.example.esercizio6.repository.ProfessionRepository;
import com.example.esercizio6.validation.Validate;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ProfessionRepository professionRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository,
                             ProfessionRepository professionRepository,
                             PersonMapper personMapper ) {
        this.personRepository = personRepository;
        this.professionRepository = professionRepository;
        this.personMapper= personMapper;
    }

    public PersonDtoResponse createPerson(PersonDtoRequest personDtoRequest) throws Exception {
        Profession profession = professionRepository.findByName(personDtoRequest.getProfession());
        if (profession == null) {
            throw new ResourceNotFoundException("Profession not found.");
        }
        Person person = Person.builder()
                .name(personDtoRequest.getName())
                .surname(personDtoRequest.getSurname())
                .profession(profession)
                .build();//new Person(personDto.getName(),personDto.getSurname());
        personRepository.save(person);
        return personMapper.map(person);
    }
    public List<PersonDtoResponse> getAllPeople(){
        List<Person> personList = personRepository.findAll();
        return personMapper.mapAll(personList);
    }

    public PersonDtoResponse getPersonById(UUID id){
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid uuid"));
        return personMapper.map(person);
    }
    public void deletePerson(UUID id){
         personRepository.deleteById(id);
    }

    public List<String> findByNameStartingWith(String startingLetter) {
        return personRepository.findByNameStartingWith(startingLetter);
       }

    }

