package com.example.esercizio6.repository;

import com.example.esercizio6.dto.ProfessionDtoRequest;
import com.example.esercizio6.dto.ProfessionDtoResponse;
import com.example.esercizio6.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession,Integer> {
    ProfessionDtoResponse save(ProfessionDtoRequest professionDto);
    List<Profession> findAll();
    void deleteById(Integer id);
    Profession findByName(String profession);
    Optional<Profession> findById(Integer id);


}
