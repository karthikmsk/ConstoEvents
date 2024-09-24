package com.example.event.services;

import com.example.event.models.ConcertCard;
import com.example.event.repositories.ConcertCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertCardService {

    @Autowired
    private final ConcertCardRepository concertCardRepository;

    public ConcertCardService(ConcertCardRepository concertCardRepository) {
        this.concertCardRepository = concertCardRepository;
    }

    public List<ConcertCard> getAllConcertCards() {
        return concertCardRepository.findAll();
    }

    public Optional<ConcertCard> getConcertCardById(Long id) {
        return concertCardRepository.findById(id);
    }

    public ConcertCard createConcertCard(ConcertCard concertCard) {
        return concertCardRepository.save(concertCard);
    }

    public ConcertCard updateConcertCard(Long id, ConcertCard concertCardDetails) {
        ConcertCard concertCard = concertCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConcertCard not found"));
        concertCard.setImageUrl(concertCardDetails.getImageUrl());
        concertCard.setTitle(concertCardDetails.getTitle());
        concertCard.setVenue(concertCardDetails.getVenue());
        concertCard.setPrice(concertCardDetails.getPrice());
        concertCard.setDate(concertCardDetails.getDate());
        concertCard.setTime(concertCardDetails.getTime());
        return concertCardRepository.save(concertCard);
    }

    public void deleteConcertCard(Long id) {
        ConcertCard concertCard = concertCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConcertCard not found"));
        concertCardRepository.delete(concertCard);
    }
}
