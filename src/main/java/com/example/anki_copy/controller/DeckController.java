package com.example.anki_copy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anki_copy.dto.AtualizarDeckDto;
import com.example.anki_copy.dto.CriarDeckDto;
import com.example.anki_copy.dto.DeckResponseDTO;
import com.example.anki_copy.service.DeckService;

@RestController
@RequestMapping("/decks")

public class DeckController {
    private DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @PostMapping()
    public ResponseEntity<Void> criarDeck(@RequestBody CriarDeckDto dto) {
        deckService.criarDeck(dto.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Void> alterarDeck(@PathVariable Integer id, @RequestBody AtualizarDeckDto dto) {
        deckService.editarDeck(id, dto.getName());
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<DeckResponseDTO>> listarDecks() {
        return ResponseEntity.ok(deckService.listarDecks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Integer id){
        deckService.deletar(id);
        return ResponseEntity.noContent().build();
    }   

}
