package com.ss.societymanagment.repository;

import com.ss.societymanagment.model.SecurityGuard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityGuardRepository extends JpaRepository<SecurityGuard, Long> {
    List<SecurityGuard> findByStatus(String status);

    // This method retrieves security guards based on their status (e.g., "Active", "Inactive")
    List<SecurityGuard> findByShiftTiming(String shiftTiming);
    // JpaRepository provides CRUD operations for the SecurityGuard entity
}