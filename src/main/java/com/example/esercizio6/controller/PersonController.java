package com.example.esercizio6.controller;

import com.example.esercizio6.dto.PersonDtoRequest;
import com.example.esercizio6.dto.PersonDtoResponse;
import com.example.esercizio6.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<List<String>> getNamesByChar(@RequestParam String startingLetter){
       List<String> nameList = personService.findByNameStartingWith(startingLetter);
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


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
