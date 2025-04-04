package com.example.controller;

import com.example.model.Vendor;
import com.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
@CrossOrigin(origins = "http://localhost:5173/") // Adjust as needed

public class VendorController {

    @Autowired
    private VendorService vendorService;

    // Add vendor
    @PostMapping("/add-vendors")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }

    // Get all vendors
    @GetMapping("/all-vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // Get vendors by service
    @GetMapping("/service/{service}")
    public List<Vendor> getVendorsByService(@PathVariable String service) {
        return vendorService.getVendorsByService(service);
    }

    // Delete vendor by ID
    @DeleteMapping("/delete/{id}")
    public String deleteVendor(@PathVariable String id) {
        vendorService.deleteVendor(id);
        return "Vendor deleted and serial numbers updated";
    }
}
