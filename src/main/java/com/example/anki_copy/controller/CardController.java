package com.example.anki_copy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.anki_copy.dto.CardRequest;
import com.example.anki_copy.dto.CardResponseDto;
import com.example.anki_copy.model.Card;
import com.example.anki_copy.service.CardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor

public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponseDto> criarCard(
            @RequestBody CardRequest request) {

        Card card = cardService.criarCard(
                request.getFront(),
                request.getBack(),
                request.getLevel(),
                request.getDeckId());

        CardResponseDto response = new CardResponseDto(
                card.getId(),
                card.getFront(),
                card.getBack(),
                card.getLevel(),
                card.getDeck().getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<CardResponseDto>> listarCard(
            @RequestParam(required = false) Integer deckId) {

        List<Card> cards = (deckId != null)
                ? cardService.listarPorDeck(deckId)
                : cardService.listarCards();

        List<CardResponseDto> response = cards.stream()
                .map(c -> new CardResponseDto(
                        c.getId(),
                        c.getFront(),
                        c.getBack(),
                        c.getLevel(),
                        c.getDeck().getId()))
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/cards/run")
    public ResponseEntity<Card> runCard(@RequestParam Integer deckId){
        return ResponseEntity.ok(cardService.runCard(deckId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cardService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
