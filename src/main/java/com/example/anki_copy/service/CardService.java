package com.example.anki_copy.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.example.anki_copy.enums.Level;
import com.example.anki_copy.model.Card;
import com.example.anki_copy.model.Deck;
import com.example.anki_copy.repository.CardRepository;
import com.example.anki_copy.repository.DeckRepository;

@Service
public class CardService {
    private CardRepository cardRepository;
    private DeckRepository deckRepository;

    public CardService(CardRepository repository, DeckRepository deckRepository) {
        this.cardRepository = repository;
        this.deckRepository = deckRepository;
    }

    public Card criarCard(String front, String back, Level level, Integer deckId) {

        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck não encontrado"));

        return cardRepository.findByFrontAndBack(front, back)
                .orElseGet(() -> cardRepository.save(new Card(front, back, level, deck)));
    }

    public List<Card> listarCards() {
        var cards = cardRepository.findAll();
        if (cards.isEmpty()) {
            throw new RuntimeException("Lista de Cards está vazia");
        }
        return cards;
    }

    public List<Card> listarPorDeck(Integer deckId) {

        List<Card> cards = cardRepository.findByDeckId(deckId);

        if (cards.isEmpty()) {
            throw new RuntimeException("Nenhum card encontrado para esse deck");
        }

        return cards;
    }

    public void deletar(Integer id) {
        cardRepository.deleteById(id);
    }
}
