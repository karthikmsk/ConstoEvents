package com.example.event.controllers;

import com.example.event.models.Book;
import com.example.event.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBookings() {
        return ResponseEntity.ok(bookService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookingById(@PathVariable Long id) {
        return bookService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createBooking(@RequestBody Book booking) {
        Book createdBooking = bookService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBooking(@PathVariable Long id, @RequestBody Book bookingDetails) {
        Book updatedBooking = bookService.updateBooking(id, bookingDetails);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
