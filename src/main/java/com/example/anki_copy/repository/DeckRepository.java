package com.example.anki_copy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anki_copy.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, Integer>{
    
}
