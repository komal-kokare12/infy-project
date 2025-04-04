package com.example.service;

import com.example.controller.EventDto;
import com.example.model.Event;
import com.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Add this createEvent method
    public Event createEvent(EventDto eventDto) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setStart(eventDto.getStart());
        event.setEnd(eventDto.getEnd());
        event.setDescription(eventDto.getDescription());
        event.setAllDay(eventDto.isAllDay());
        event.setImageUrl(eventDto.getImageUrl());

        return eventRepository.save(event);
    }

//    // Add these other required methods if missing
//    public List<Event> getAllEvents() {
//        return eventRepository.findAll();
//    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Event not found with id: " + id));
    }

    public Event saveEvent(Event event) {
        // Set default end time if not provided
        if (event.getEnd() == null && event.getStart() != null) {
            event.setEnd(event.getStart().plusHours(1));
        }
        return eventRepository.save(event);
    }

    public Event updateEvent(String id, Event eventDetails) {
        Event event = getEventById(id);

        event.setTitle(eventDetails.getTitle());
        event.setStart(eventDetails.getStart());
        event.setEnd(eventDetails.getEnd());
        event.setDescription(eventDetails.getDescription());
        event.setAllDay(eventDetails.isAllDay());
        event.setImageUrl(eventDetails.getImageUrl());

        return eventRepository.save(event);
    }

    public void deleteEvent(String id) {
        if (!eventRepository.existsById(id)) {
            throw new NoSuchElementException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }
}