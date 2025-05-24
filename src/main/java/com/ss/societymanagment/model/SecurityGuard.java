package com.ss.societymanagment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "security_guards")
public class SecurityGuard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name; // e.g., John Doe
    private String contactNumber; // e.g., +1-234-567-8900
    private String address; // e.g., 123 Main St, City, State
    private String shiftTiming;//e.g., Morning, Evening, Night
    private String assignedArea; // e.g., Block A, Block B
    private String status; // e.g., Active, Inactive
    private String joiningDate; // e.g., 2023-01-01
    private String salary; // e.g., 5000
    private String photo; // e.g., URL or file path to the guard's photo


    /*@Version
    private int version; // Optimistic locking field*/

}