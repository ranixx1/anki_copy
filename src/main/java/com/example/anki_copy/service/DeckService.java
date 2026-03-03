package com.example.anki_copy.service;

import java.util.List;

import com.example.anki_copy.model.Card;
import com.example.anki_copy.model.Deck;
import com.example.anki_copy.repository.DeckRepository;

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

    public List<Deck> listarDecks() {
        var decks = deckRepository.findAll();
        if (decks.isEmpty()) {
            throw new RuntimeException("Não há Decks");
        }
        return decks;
    }

    public List<Card> detalharDeck(String nome) {
        Deck deck = deckRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Deck não encontrado."));
        return deck.getCards();
    }
}
