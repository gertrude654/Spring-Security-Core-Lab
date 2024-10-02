package com.example.SpringSecurityLab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "UserController", description = "API for user role-based dashboard access")
public class UserController {

    @Operation(summary = "Home page for all users")
    @GetMapping("/homeR")
    public ResponseEntity<String> homeRole() {
        return ResponseEntity.ok("Welcome to the home role page");
    }

    @Operation(summary = "Home page accessible by all roles")
    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to the home page accessible by all");
    }

    @Operation(summary = "Employee dashboard", description = "Accessible by users with the EMPLOYEE role")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/employee/dashboard")
    public ResponseEntity<String> employeeDashboard() {
        return ResponseEntity.ok("Welcome to the employee dashboard");
    }

    @Operation(summary = "Manager dashboard", description = "Accessible by users with the MANAGER role")
    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/manager/dashboard")
    public ResponseEntity<String> managerDashboard() {
        return ResponseEntity.ok("Welcome to the manager dashboard");
    }

    @Operation(summary = "Admin dashboard", description = "Accessible by users with the ADMIN role")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/dashboard")
    public ResponseEntity<String> adminDashboard() {
        return ResponseEntity.ok("Welcome to the admin dashboard");
    }

    @Operation(summary = "Access denied page")
    @GetMapping("/access-denied")
    public ResponseEntity<String> accessDenied() {
        return ResponseEntity.status(403).body("Access denied");
    }
}
