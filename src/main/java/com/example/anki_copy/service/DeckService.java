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

    public DeckResponseDTO criarDeck(String name) {

        Deck deck = deckRepository.save(new Deck(name));
        return new DeckResponseDTO(
                deck.getId(),
                deck.getNome());
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
                .map(deck -> new DeckResponseDTO(deck.getId(), deck.getNome()))
                .toList();
    }

    public List<Card> detalharDeck(String nome) {
        Deck deck = deckRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Deck não encontrado."));
        return deck.getCards();
    }

    public void deletar(Integer id) {
        deckRepository.deleteById(id);
    }
}
