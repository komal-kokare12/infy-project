package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "events")
public class Event {
    @Id
    private String id;  // Changed from Long to String for MongoDB

    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;
    private boolean allDay;
    private String imageUrl;

    // Constructors
    public Event() {}

    public Event(String title, LocalDateTime start, LocalDateTime end,
                 String description, boolean allDay, String imageUrl) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.description = description;
        this.allDay = allDay;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDateTime getStart() { return start; }
    public void setStart(LocalDateTime start) { this.start = start; }

    public LocalDateTime getEnd() { return end; }
    public void setEnd(LocalDateTime end) { this.end = end; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isAllDay() { return allDay; }
    public void setAllDay(boolean allDay) { this.allDay = allDay; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}