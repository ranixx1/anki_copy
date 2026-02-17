package com.example.anki_copy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anki_copy.enums.Level;
import com.example.anki_copy.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer>{
    List<Card> findByLevel(Level level);
    Optional<Card> findByFrontAndBack(String front, String back);
}
