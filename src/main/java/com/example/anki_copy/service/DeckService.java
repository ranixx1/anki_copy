package com.example.anki_copy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.anki_copy.dto.DeckResponseDTO;
import com.example.anki_copy.model.Card;
import com.example.anki_copy.model.Deck;
import com.example.anki_copy.repository.DeckRepository;

@Service
public class DeckService {
    private DeckRepository deckRepository;

    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public Deck criarDeck(String nome) {
        Deck deck = new Deck();
        deck.setNome(nome);
        return deckRepository.save(deck);
    }

    public Deck editarDeck(Integer id, String newName) {
        Deck newDeck = deckRepository.findById(id).orElseThrow(() -> new RuntimeException("Deck não encontrado"));
        if (newDeck.getNome().equals(newName)) {
            throw new IllegalArgumentException("O nome tem que ser diferente.");
        }
        newDeck.setNome(newName);
        return deckRepository.save(newDeck);

    }

    public List<DeckResponseDTO> listarDecks() {

        List<Deck> decks = deckRepository.findAll();

        return decks.stream()
                .map(deck -> new DeckResponseDTO(deck.getId(),deck.getNome()))
                .toList();
    }

    public List<Card> detalharDeck(String nome) {
        Deck deck = deckRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Deck não encontrado."));
        return deck.getCards();
    }
}
