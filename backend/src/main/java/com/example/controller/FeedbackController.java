package com.example.controller;

import com.example.model.Feedback;
import com.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "http://localhost:5173/") // Adjust frontend URL if needed
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // POST: Submit feedback
    @PostMapping("/submit-feedback")
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    // GET: Retrieve all feedback
    @GetMapping("/all-feedback")
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
}
