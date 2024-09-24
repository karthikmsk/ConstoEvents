package com.example.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event.models.ConcertCard;

public interface ConcertCardRepository extends JpaRepository<ConcertCard, Long> {

}
