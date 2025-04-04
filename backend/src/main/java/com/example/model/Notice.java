package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "notices")
public class Notice {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime scheduleAt;
    private boolean isImportant;
    private String createdBy; // Added to track who created the notice
    private LocalDateTime createdAt; // Added for audit purposes

    // Constructors
    public Notice() {
        this.createdAt = LocalDateTime.now();
    }

    public Notice(String title, String content, LocalDateTime scheduleAt, boolean isImportant) {
        this();
        this.title = title;
        this.content = content;
        this.scheduleAt = scheduleAt;
        this.isImportant = isImportant;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getScheduleAt() { return scheduleAt; }
    public void setScheduleAt(LocalDateTime scheduleAt) { this.scheduleAt = scheduleAt; }

    public boolean isImportant() { return isImportant; }
    public void setImportant(boolean important) { isImportant = important; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}