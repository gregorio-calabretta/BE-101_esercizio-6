package com.example.esercizio6.service;

import com.example.esercizio6.dto.ProfessionDtoRequest;
import com.example.esercizio6.dto.ProfessionDtoResponse;
import com.example.esercizio6.mapper.ProfessionMapper;
import com.example.esercizio6.model.Person;
import com.example.esercizio6.model.Profession;
import com.example.esercizio6.repository.PersonRepository;
import com.example.esercizio6.repository.ProfessionRepository;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    private final ProfessionRepository professionRepository;
    private final PersonRepository personRepository;
    private final ProfessionMapper professionMapper;
    public ProfessionServiceImpl(ProfessionRepository professionRepository, PersonRepository personRepository,ProfessionMapper professionMapper) {
        this.professionRepository = professionRepository;
        this.personRepository = personRepository;
        this.professionMapper = professionMapper;
    }
    public ProfessionDtoResponse addProfession(ProfessionDtoRequest professionDto){
        Profession profession =  Profession.builder().id(professionDto.getId()).name(professionDto.getName()).build();
         professionRepository.save(profession);
        return professionMapper.map(profession);
    }
    public Profession findByNameAndSurname(String name, String surname) {
        Person person = personRepository.findByNameAndSurname(name,surname);
        return person.getProfession();
    }
    public ProfessionDtoResponse getProfessionById(Integer id) {
        Profession profession = professionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        return professionMapper.map(profession);
    }
    public List<ProfessionDtoResponse> getAllProfessions(){
        List<Profession> professionList = professionRepository.findAll();
        return professionMapper.mapAll(professionList);
    }
    public void deleteById(Integer id){
        professionRepository.deleteById(id);
    }

    public void updateProfession(Integer id,String name){
        Profession myProfession = professionRepository.findById(id).orElseThrow(() -> new IllegalIdentifierException("Invalid id"));
        myProfession.setName(name);
        professionRepository.save(myProfession);
    }
}
