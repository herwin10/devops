package com.example4052hdash.h_dash.controller;

import com.example4052hdash.h_dash.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Handle login requests
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, 
                        @RequestParam("password") String password, 
                        Model model) {
        boolean isAuthenticated = loginService.authenticateUser(email, password);

        if (isAuthenticated) {
            return "welcome";  // Redirect to the welcome page on successful login
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";  // Return to login page with an error message
        }
    }

    // Optional: Display the login form
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // This will map to login.html (Thymeleaf template)
    }
}
