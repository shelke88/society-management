package com.ss.societymanagment.services;

import com.ss.societymanagment.model.SecurityGuard;
import com.ss.societymanagment.repository.SecurityGuardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityGuardServices {

    @Autowired
    private SecurityGuardRepository securityGuardRepository;

    public List<SecurityGuard> getGuardsByStatus(String status) {
        return securityGuardRepository.findByStatus(status);
    }

    @Transactional
    public void addSecurityGuard(SecurityGuard securityGuard) {
        // Logic to add a new security guard
        // This could include validation, setting default values, etc.
        securityGuardRepository.save(securityGuard);
        System.out.println("Security guard ID: " + securityGuard.getId());
        System.out.println("Security guard added: " + securityGuard.getName());
    }

    public List<SecurityGuard> getCurrentShiftSecurityGuard(String shiftTiming) {
        // Logic to retrieve active security guards based on shift timing
        // This could involve querying the database for guards with the specified shift timing
        return securityGuardRepository.findByShiftTiming(shiftTiming);
    }

    public List<SecurityGuard> getAllSecurityGuards() {
        return securityGuardRepository.findAll();
    }


    @Transactional
    public SecurityGuard updateSecurityGuard(long id, SecurityGuard updatedGuard) {
        SecurityGuard existingGuard = securityGuardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Security guard not found with ID: " + id));

        // Update fields
        existingGuard.setName(updatedGuard.getName());
        existingGuard.setContactNumber(updatedGuard.getContactNumber());
        existingGuard.setAddress(updatedGuard.getAddress());
        existingGuard.setShiftTiming(updatedGuard.getShiftTiming());
        existingGuard.setAssignedArea(updatedGuard.getAssignedArea());
        existingGuard.setStatus(updatedGuard.getStatus());
        existingGuard.setJoiningDate(updatedGuard.getJoiningDate());
        existingGuard.setSalary(updatedGuard.getSalary());
        existingGuard.setPhoto(updatedGuard.getPhoto());

        return securityGuardRepository.save(existingGuard);
    }

    @Transactional
    public void deleteSecurityGuard(long id) {
        SecurityGuard existingGuard = securityGuardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Security guard not found with ID: " + id));
        securityGuardRepository.delete(existingGuard);
        System.out.println("Security guard deleted with ID: " + id);
    }

    @Transactional
    public void deleteAllSecurityGuards() {
        securityGuardRepository.deleteAll();
        System.out.println("All security guards deleted.");
    }
    @Transactional
    public void addSampleSecurityGuards() {
        System.out.println("Adding sample security guards...");

        securityGuardRepository.save(new SecurityGuard(1, "John Doe", "+1-234-567-8900", "123 Main St, City, State", "Morning", "Block A", "Active", "2023-01-01", "5000", "photo_url_1"));
        securityGuardRepository.save(new SecurityGuard(2, "Jane Smith", "+1-987-654-3210", "456 Elm St, City, State", "Evening", "Block B", "Inactive", "2023-02-01", "4500", "photo_url_2"));
        securityGuardRepository.save(new SecurityGuard(3, "Mike Johnson", "+1-555-555-5555", "789 Oak St, City, State", "Night", "Block C", "Active", "2023-03-01", "4800", "photo_url_3"));
        securityGuardRepository.save(new SecurityGuard(4, "Alice Brown", "+1-111-222-3333", "101 Maple St, City, State", "Evening", "Block D", "Inactive", "2023-04-01", "4000", "photo_url_4"));
        securityGuardRepository.save(new SecurityGuard(5, "Bob White", "+1-444-555-6666", "202 Pine St, City, State", "Night", "Block E", "Inactive", "2023-05-01", "4200", "photo_url_5"));

        System.out.println("Sample security guards added successfully!");
    }

}
