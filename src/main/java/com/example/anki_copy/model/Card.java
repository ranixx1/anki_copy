package com.example.anki_copy.model;


import com.example.anki_copy.enums.Level;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
public class Card {
    public Card() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "front")
    private String front;

    @Column(name = "back")
    private String back;

    @Enumerated(EnumType.STRING)
    private Level level;

    public Card(String front, String back, Level level) {
        if(front == null || back == null){
            throw new IllegalArgumentException("Informações insuficientes");
        }
        this.front = front;
        this.back = back;
        this.level = level;
    }
}
