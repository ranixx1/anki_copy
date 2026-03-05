package com.example.anki_copy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anki_copy.dto.AtualizarDeckDto;
import com.example.anki_copy.dto.CriarDeckDto;
import com.example.anki_copy.service.DeckService;

@RestController
@RequestMapping("/cards")

public class DeckController {
    private DeckService deckService;

    @GetMapping()
    public ResponseEntity<Void> criarCard(@RequestBody CriarDeckDto dto){
        deckService.criarDeck(dto.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Void> alterarDeck(@PathVariable Integer id, @RequestBody AtualizarDeckDto dto) {
        deckService.editarDeck(id, dto.getName());
        return ResponseEntity.noContent().build();

    }
}
