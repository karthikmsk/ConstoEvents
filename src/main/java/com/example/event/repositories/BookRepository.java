package com.example.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
