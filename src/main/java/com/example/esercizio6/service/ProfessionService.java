package com.example.esercizio6.service;


import com.example.esercizio6.dto.ProfessionDtoRequest;
import com.example.esercizio6.dto.ProfessionDtoResponse;
import com.example.esercizio6.model.Profession;

import java.util.List;

public interface ProfessionService {
     ProfessionDtoResponse addProfession(ProfessionDtoRequest profession);
     Profession findByNameAndSurname(String name, String surname);
     ProfessionDtoResponse getProfessionById(Integer id);
     List<ProfessionDtoResponse> getAllProfessions();
     void  deleteById(Integer id);
     public void updateProfession(Integer id,String name);
}
