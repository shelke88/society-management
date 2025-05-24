package com.ss.societymanagment.controllers;

import com.ss.societymanagment.model.SecurityGuard;
import com.ss.societymanagment.services.SecurityGuardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityGuardManagement {
    // Add methods to manage security guards here
    // For example, you can add methods to add, update, delete, and retrieve security guard information


    @Autowired
    private SecurityGuardServices securityGuardServices;
    // Example method to get all security guards

    @GetMapping("/get-sample-guards")
    public List<SecurityGuard> getSampleSecurityGuards() {
        // This method can return a sample list of security guards
        return List.of(
                new SecurityGuard(1, "John Doe", "+1-234-567-8900", "123 Main St, City, State", "Morning", "Block A", "Active", "2023-01-01", "5000", "photo_url_1"),
                new SecurityGuard(2, "Jane Smith", "+1-987-654-3210", "456 Elm St, City, State", "Evening", "Block B", "Inactive", "2023-02-01", "4500", "photo_url_2"),
                new SecurityGuard(3, "Mike Johnson", "+1-555-555-5555", "789 Oak St, City, State", "Night", "Block C", "Active", "2023-03-01", "4800", "photo_url_3")
        );
    }


    @GetMapping("/get-guards")
    public List<SecurityGuard> getAllSecurityGuards() {
        return securityGuardServices.getAllSecurityGuards();

        /*List.of(
                new SecurityGuard(1, "John Doe", "+1-234-567-8900", "123 Main St, City, State", "Morning", "Block A", "Active", "2023-01-01", "5000", "photo_url_1"),
                new SecurityGuard(2, "Jane Smith", "+1-987-654-3210", "456 Elm St, City, State", "Evening", "Block B", "Inactive", "2023-02-01", "4500", "photo_url_2"),
                new SecurityGuard(3, "Mike Johnson", "+1-555-555-5555", "789 Oak St, City, State", "Night", "Block C", "Active", "2023-03-01", "4800", "photo_url_3")
        );*/
    }

    // Example method to add a new security guard
    @PostMapping("/add-guards")
    public String addSecurityGuard(@RequestBody SecurityGuard securityGuard) {
        // Implement logic to add a new security guard
        securityGuardServices.addSecurityGuard(securityGuard);
        return "Security guard added successfully!";
    }

    @GetMapping("/get-current-shift/{shiftTiming}")
    public List<SecurityGuard> getCurrentShiftSecurityGuard(@PathVariable String shiftTiming) {
        // Implement logic to retrieve active security guards based on shift timing
        System.out.println("Retrieving current shift security guards for shift: " + shiftTiming);
        return securityGuardServices.getCurrentShiftSecurityGuard(shiftTiming);
    }
    // Example URL: /get-current-shift/Morning

    @GetMapping("/guards")
    public List<SecurityGuard> getGuardsByStatus(@RequestParam String status) {
        // Binds the 'status' query parameter from the URL
        return securityGuardServices.getGuardsByStatus(status);
    }
// Example URL: /guards?status=Active

    @PutMapping("/update-guard/{id}")
    public SecurityGuard updateSecurityGuard(@PathVariable("id") long id, @RequestBody SecurityGuard updatedGuard) {
        // Implement logic to update an existing security guard
        return securityGuardServices.updateSecurityGuard(id, updatedGuard);
    }

    @DeleteMapping("/delete-guard/{id}")
    public String deleteSecurityGuard(@PathVariable long id) {
        // Implement logic to delete a security guard by ID
        securityGuardServices.deleteSecurityGuard(id);
        return "Security guard deleted successfully!";
    }

    @DeleteMapping("/delete-all-guards")
    public String deleteAllSecurityGuards() {
        // Implement logic to delete all security guards
        securityGuardServices.deleteAllSecurityGuards();
        return "All security guards deleted successfully!";
    }

}
