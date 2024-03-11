package com.example.esercizio6.repository;

import com.example.esercizio6.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person,UUID> {
    Person save(Person person);
    List<Person> findAll();
    void deleteById(UUID id);
    Optional<Person> findById(UUID id);
    Person findByNameAndSurname(String name, String surname);
    @Query(value = "SELECT name FROM Person WHERE name LIKE CONCAT(:startingLetter,'%') ",nativeQuery = true)
    List<String> findByNameStartingWith(@Param("startingLetter") String startingLetter);
}
