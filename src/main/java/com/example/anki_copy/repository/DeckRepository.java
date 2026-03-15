package com.example.anki_copy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anki_copy.model.Deck;

@Repository

public interface DeckRepository extends JpaRepository<Deck, Integer> {
    Optional<Deck> findByNome(String nome);

    Optional<Deck> findByNomeIgnoreCase(String nome);

}
