package com.example.anki_copy.model;


import lombok.Getter;
import lombok.Setter;

import com.example.anki_copy.enums.Level;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Card {
    public Card() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "front", unique = true)
    private String front;

    @Column(name = "back", unique = true)
    private String back;

    @Enumerated(EnumType.STRING)
    private Level level;
    

    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonBackReference
    private Deck deck;

    public Card(String front, String back, Level level, Deck deck) {
        if(front == null || back == null){
            throw new IllegalArgumentException("Informações insuficientes");
        }
        this.front = front;
        this.back = back;
        this.level = level;
        this.deck = deck;
    }
}
