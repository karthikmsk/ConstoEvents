
package com.example.event.services;

import com.example.event.models.Book;
import com.example.event.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBookings() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookingById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBooking(Book booking) {
        return bookRepository.save(booking);
    }

    public Book updateBooking(Long id, Book bookingDetails) {
        Book booking = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setName(bookingDetails.getName());
        booking.setContactNumber(bookingDetails.getContactNumber());
        booking.setLocation(bookingDetails.getLocation());
        booking.setAddress(bookingDetails.getAddress());
        booking.setNumberOfTickets(bookingDetails.getNumberOfTickets());
        booking.setBookingDate(bookingDetails.getBookingDate());
        return bookRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Book booking = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        bookRepository.delete(booking);
    }
}
