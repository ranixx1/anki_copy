package com.example.anki_copy.service;

import com.example.anki_copy.repository.CardRepository;
import com.example.anki_copy.repository.DeckRepository;

public class DeckService {
    private DeckRepository deckreRepository;
    private CardRepository cardRepository;

    public DeckService(DeckRepository deckRepository, CardRepository cardRepository) {
        this.deckreRepository = deckRepository;
        this.cardRepository = cardRepository;
    }

}
