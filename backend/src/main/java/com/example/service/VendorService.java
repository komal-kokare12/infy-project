package com.example.service;

import com.example.model.Vendor;
import com.example.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    // Add vendor with auto-incremented serial number
    public Vendor addVendor(Vendor vendor) {
        List<Vendor> vendors = vendorRepository.findAllByOrderBySerialNoAsc();
        int serialNo = vendors.isEmpty() ? 1 : vendors.get(vendors.size() - 1).getSerialNo() + 1;
        vendor.setSerialNo(serialNo);
        return vendorRepository.save(vendor);
    }

    // Get all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAllByOrderBySerialNoAsc();
    }

    // Get vendors by service
    public List<Vendor> getVendorsByService(String service) {
        return vendorRepository.findByService(service);
    }

    /// Delete vendor and reassign serial numbers
    public void deleteVendor(String id) {
        // Find the vendor to be deleted
        Vendor vendorToDelete = vendorRepository.findById(id).orElse(null);
        if (vendorToDelete == null) {
            return;
        }

        int deletedSerialNo = vendorToDelete.getSerialNo(); // Store the deleted vendor's serial number

        // Delete the vendor
        vendorRepository.deleteById(id);

        // Find all vendors sorted by serial number
        List<Vendor> vendors = vendorRepository.findAllByOrderBySerialNoAsc();

        // Reassign serial numbers to fill the gap
        for (Vendor vendor : vendors) {
            if (vendor.getSerialNo() > deletedSerialNo) {
                vendor.setSerialNo(vendor.getSerialNo() - 1);
                vendorRepository.save(vendor);
            }
        }
    }
}
