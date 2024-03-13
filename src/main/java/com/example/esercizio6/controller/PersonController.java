package com.example.esercizio6.controller;

import com.example.esercizio6.annotations.IsLetter;
import com.example.esercizio6.dto.PersonDtoRequest;
import com.example.esercizio6.dto.PersonDtoResponse;
import com.example.esercizio6.exception.ApiExceptionHandler;
import com.example.esercizio6.exception.InvalidInputException;
import com.example.esercizio6.exception.ResourceNotFoundException;
import com.example.esercizio6.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Validated
@RequestMapping("/api/v1/persons")
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDtoResponse> createPerson(@RequestBody PersonDtoRequest person) throws Exception {
        PersonDtoResponse responseDTO  = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getNamesByChar(@RequestParam  @IsLetter(propName = "startingLetter") String startingLetter){
        List<String> nameList;
        nameList = personService.findByNameStartingWith(startingLetter);
        if (nameList.isEmpty()) {
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(nameList);
    }


    @GetMapping
    public ResponseEntity<List<PersonDtoResponse>> getAllPeople(){
        List<PersonDtoResponse> personListDTOs = personService.getAllPeople();
        return ResponseEntity.status(HttpStatus.OK).body(personListDTOs);
    }

    @GetMapping(path = "{personUuid}")
    public ResponseEntity<PersonDtoResponse> getPersonById(@PathVariable("personUuid") UUID id){
        PersonDtoResponse responseDTO = personService.getPersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping(path = "{personUuid}")
    public void deletePersonById(@PathVariable("personUuid") UUID id){
        personService.deletePerson(id);
    }


}
