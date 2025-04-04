package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedback")
public class Feedback {
    
    @Id
    private String id;
    private String about;   // Event or service being reviewed
    private String feedback; // User's feedback
    private int rating;    // Rating (out of 5)

    public Feedback() {}

    public Feedback(String about, String feedback, int rating) {
        this.about = about;
        this.feedback = feedback;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
