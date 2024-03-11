package com.example.esercizio6.controller;

import com.example.esercizio6.dto.ProfessionDtoRequest;
import com.example.esercizio6.dto.ProfessionDtoResponse;
import com.example.esercizio6.model.Profession;
import com.example.esercizio6.service.ProfessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professions")
public class ProfessionController {

    private  ProfessionService professionService;

    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping
    public ResponseEntity<ProfessionDtoResponse> addProfession(@RequestBody ProfessionDtoRequest professionDto){
        ProfessionDtoResponse responseDTO  = professionService.addProfession(professionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
     @GetMapping
    public Profession findProfessionByPersonNameSurname(@RequestParam String name, @RequestParam String surname){
        return professionService.findByNameAndSurname(name,surname);
    }
    @GetMapping(path = "{professionId}")
    public ResponseEntity<ProfessionDtoResponse> getProfessionById(@PathVariable("professionId") Integer id){
        ProfessionDtoResponse responseDTO = professionService.getProfessionById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
    @GetMapping(path = "/")
    public ResponseEntity<List<ProfessionDtoResponse>> getAllProfessions(){
        List<ProfessionDtoResponse> professionListDTOs = professionService.getAllProfessions();
        return ResponseEntity.status(HttpStatus.OK).body(professionListDTOs);
    }
    @DeleteMapping(path = "{professionId}")
    public void deleteProfessionById(@PathVariable("professionId")Integer id ){
        professionService.deleteById(id);
    }

    @PutMapping
    public void updateNameById(@RequestParam Integer id,@RequestParam String name){
        professionService.updateProfession( id, name);
    }


}
