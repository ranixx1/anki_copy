package com.example.anki_copy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anki_copy.dto.CardRequest;
import com.example.anki_copy.model.Card;
import com.example.anki_copy.service.CardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor

public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<Card> criarCard(@RequestBody CardRequest request) {
        Card novoCard = cardService.criarCard(request.getFront(), request.getBack(), request.getLevel(),
                request.getDeckId());
        return ResponseEntity.status(201).body(novoCard);

    }

    @GetMapping
    public ResponseEntity<List<Card>> listarCard() {
        return ResponseEntity.ok(cardService.listarCards());
    }

}
