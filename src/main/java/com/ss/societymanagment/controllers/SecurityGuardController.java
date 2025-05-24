package com.ss.societymanagment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityGuardController {
    // This controller handles requests related to security guard management
    @GetMapping("/security-guard-management")
    public String showSecurityGuardManagementPage() {
        return "security-guard-management"; // This corresponds to the Thymeleaf template name
    }


}