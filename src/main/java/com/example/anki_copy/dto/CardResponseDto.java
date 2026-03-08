package com.example.anki_copy.dto;

import com.example.anki_copy.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardResponseDto {

    private Integer id;
    private String front;
    private String back;
    private Level level;
    private Integer deckId;
}