package com.ss.societymanagment.controllers;

import com.ss.societymanagment.model.SecurityGuard;
import com.ss.societymanagment.services.SecurityGuardServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityGuardManagement {

    @Autowired
    private SecurityGuardServices securityGuardServices;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the sample list of security guards")
    })
    @GetMapping("/get-sample-guards")
    public List<SecurityGuard> getSampleSecurityGuards() {
        return List.of(
                new SecurityGuard(1, "John Doe", "+1-234-567-8900", "123 Main St, City, State", "Morning", "Block A", "Active", "2023-01-01", "5000", "photo_url_1"),
                new SecurityGuard(2, "Jane Smith", "+1-987-654-3210", "456 Elm St, City, State", "Evening", "Block B", "Inactive", "2023-02-01", "4500", "photo_url_2"),
                new SecurityGuard(3, "Mike Johnson", "+1-555-555-5555", "789 Oak St, City, State", "Night", "Block C", "Active", "2023-03-01", "4800", "photo_url_3")
        );
    }

    @Operation(summary = "Retrieve all security guards", description = "Fetches a list of all security guards from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of security guards"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred while fetching the data")
    })
    @GetMapping("/get-guards")
    public List<SecurityGuard> getAllSecurityGuards() {
        return securityGuardServices.getAllSecurityGuards();
    }

    @Operation(summary = "Add a new security guard", description = "Adds a new security guard to the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Security guard added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data provided")
    })
    @PostMapping("/add-guards")
    public String addSecurityGuard(@RequestBody SecurityGuard securityGuard) {
        securityGuardServices.addSecurityGuard(securityGuard);
        return "Security guard added successfully!";
    }

    @Operation(summary = "Retrieve security guards for the current shift", description = "Fetches a list of security guards assigned to the specified shift.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of security guards for the shift"),
            @ApiResponse(responseCode = "404", description = "No security guards found for the specified shift")
    })
    @GetMapping("/get-current-shift/{shiftTiming}")
    public List<SecurityGuard> getCurrentShiftSecurityGuard(@PathVariable String shiftTiming) {
        return securityGuardServices.getCurrentShiftSecurityGuard(shiftTiming);
    }

    @Operation(summary = "Retrieve security guards by status", description = "Fetches a list of security guards based on their status (e.g., Active, Inactive).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of security guards by status"),
            @ApiResponse(responseCode = "400", description = "Invalid status parameter provided")
    })
    @GetMapping("/guards")
    public List<SecurityGuard> getGuardsByStatus(@RequestParam String status) {
        return securityGuardServices.getGuardsByStatus(status);
    }

    @Operation(summary = "Update a security guard by ID", description = "Updates the details of a specific security guard identified by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Security guard updated successfully"),
            @ApiResponse(responseCode = "404", description = "Security guard with the specified ID not found")
    })
    @PutMapping("/update-guard/{id}")
    public SecurityGuard updateSecurityGuard(@PathVariable("id") long id, @RequestBody SecurityGuard updatedGuard) {
        return securityGuardServices.updateSecurityGuard(id, updatedGuard);
    }

    @Operation(summary = "Delete a security guard by ID", description = "Deletes a specific security guard identified by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Security guard deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Security guard with the specified ID not found")
    })
    @DeleteMapping("/delete-guard/{id}")
        public String deleteSecurityGuard(@PathVariable long id) {
            securityGuardServices.deleteSecurityGuard(id);
            return "Security guard deleted successfully! ID: " + id;
    }

    @Operation(summary = "Delete all security guards", description = "Deletes all security guards from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All security guards deleted successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred while deleting the data")
    })
    @DeleteMapping("/delete-all-guards")
    public String deleteAllSecurityGuards() {
        securityGuardServices.deleteAllSecurityGuards();
        return "All security guards deleted successfully!";
    }
}