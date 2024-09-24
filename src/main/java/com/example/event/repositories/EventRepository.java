package com.example.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.event.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
