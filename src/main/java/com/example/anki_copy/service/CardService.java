package com.example.anki_copy.service;

import org.springframework.stereotype.Service;

import com.example.anki_copy.enums.Level;
import com.example.anki_copy.model.Card;
import com.example.anki_copy.repository.CardRepository;

@Service
public class CardService {
    private CardRepository repository;

    public CardService(CardRepository repository){
        this.repository = repository;
    }

    public Card criarCard(String front,String back, Level level){
        return repository.findByFrontAndBack(front, back).orElseGet(() -> repository.save(new Card(front, back, level)));

    }
}
