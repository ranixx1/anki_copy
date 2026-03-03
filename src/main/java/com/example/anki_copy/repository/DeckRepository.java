package com.example.anki_copy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anki_copy.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, Integer>{
    Optional<Deck> findByNome(String nome);
}
