package com.example.esercizio6.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Profession")
public class Profession {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public Profession(@JsonProperty Integer id,@JsonProperty String name) {
        this.id = id;
        this.name = name;
    }
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private List<Person> person;
}
