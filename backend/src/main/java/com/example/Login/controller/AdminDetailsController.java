package com.example.Login.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminDetailsController {

    @GetMapping("/details")
    public String getAdminDetails() {
        return "Admin details will be here!";
    }
}
