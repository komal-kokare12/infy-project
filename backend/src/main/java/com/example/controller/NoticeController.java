package com.example.controller;

import com.example.model.Notice;
import com.example.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notices")
@CrossOrigin(origins = "*")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        // Set creation timestamp
        notice.setCreatedAt(LocalDateTime.now());

        // Validate required fields
        if (notice.getTitle() == null || notice.getTitle().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Save to database
        Notice savedNotice = noticeService.saveNotice(notice);

        // Return the saved notice with 201 status
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNotice);
    }

    @GetMapping
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return ResponseEntity.ok(notices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable String id) {
        return noticeService.getNoticeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> updateNotice(@PathVariable String id, @RequestBody Notice notice) {
        notice.setId(id);
        Notice updatedNotice = noticeService.updateNotice(notice);
        return ResponseEntity.ok(updatedNotice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable String id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}