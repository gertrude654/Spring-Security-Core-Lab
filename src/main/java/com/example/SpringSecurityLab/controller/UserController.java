//package com.example.SpringSecurityLab.controller;
//
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class UserController {
//
//    @GetMapping("/homeR")
//    public String homeRole() {
//        return "homeRole";
//    }
//    @GetMapping("/home")
//    public String home() {
//        return "home"; // returns homeRole.html (accessible by all roles)
//    }
//
//    @GetMapping("/employee/dashboard")
//    @PreAuthorize("hasRole('EMPLOYEE')")
//    public String employeeDashboard() {
//        return "employee"; // return your employee dashboard view name
//    }
//
//    @GetMapping("/manager/dashboard")
//    @PreAuthorize("hasRole('MANAGER')")
//    public String managerDashboard() {
//        return "manager";  // return your manager dashboard view name
//    }
//
//    @GetMapping("/admin/dashboard")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String adminDashboard() {
//        return "admin";  // return your admin dashboard view name
//    }
//
//    @GetMapping("/access-denied")
//    public String accessDenied() {
//        return "access-denied";  // returns access-denied.html
//    }
//}


package com.example.SpringSecurityLab.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Operation(summary = "Home page for all users")
    @GetMapping("/homeR")
    public String homeRole() {
        return "homeRole";
    }

    @Operation(summary = "Home page accessible by all roles")
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @Operation(summary = "Employee dashboard", description = "Accessible by users with the EMPLOYEE role")
    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/employee/dashboard")
    public String employeeDashboard() {
        return "employee";
    }

    @Operation(summary = "Manager dashboard", description = "Accessible by users with the MANAGER role")
    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping("/manager/dashboard")
    public String managerDashboard() {
        return "manager";
    }

    @Operation(summary = "Admin dashboard", description = "Accessible by users with the ADMIN role")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin";
    }

    @Operation(summary = "Access denied page")
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
