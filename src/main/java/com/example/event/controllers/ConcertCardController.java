package com.example.event.controllers;

import com.example.event.models.ConcertCard;
import com.example.event.services.ConcertCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerts")
public class ConcertCardController {

    @Autowired
    private final ConcertCardService concertCardService;

    public ConcertCardController(ConcertCardService concertCardService) {
        this.concertCardService = concertCardService;
    }

    @GetMapping
    public ResponseEntity<List<ConcertCard>> getAllConcertCards() {
        return ResponseEntity.ok(concertCardService.getAllConcertCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcertCard> getConcertCardById(@PathVariable Long id) {
        return concertCardService.getConcertCardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConcertCard> createConcertCard(@RequestBody ConcertCard concertCard) {
        ConcertCard createdConcertCard = concertCardService.createConcertCard(concertCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConcertCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConcertCard> updateConcertCard(@PathVariable Long id,
            @RequestBody ConcertCard concertCardDetails) {
        ConcertCard updatedConcertCard = concertCardService.updateConcertCard(id, concertCardDetails);
        return ResponseEntity.ok(updatedConcertCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcertCard(@PathVariable Long id) {
        concertCardService.deleteConcertCard(id);
        return ResponseEntity.noContent().build();
    }
}
