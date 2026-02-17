package com.example.anki_copy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anki_copy.model.Card;
import com.example.anki_copy.service.CardService;

import lombok.RequiredArgsConstructor;

@Controller
@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor


public class CardController {
    private final CardService cardService;
    @PostMapping
    public ResponseEntity<Card> criarChamado(@RequestBody Card card){
        Card novoCard = cardService.criarCard(card.getFront(),card.getBack(), card.getLevel());

        return ResponseEntity.ok(novoCard);

    }
    
}
