package com.example.anki_copy.dto;

import com.example.anki_copy.enums.Level;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CardRequest {

    private String front;
    private String back;
    private Level level;
    private Integer deckId; 

}