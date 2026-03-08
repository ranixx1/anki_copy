package com.example.anki_copy.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity
@Getter
@Setter
public class Deck {
    public Deck() {

    }

    public Deck(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", unique = true)
    private String nome;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Card> cards = new ArrayList<>();
}
