package com.example4052hdash.h_dash.service;

import com.example4052hdash.h_dash.domain.Login;
import com.example4052hdash.h_dash.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepo loginRepo;

    @Autowired
    public LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    // Method to authenticate user by email and password
    public boolean authenticateUser(String email, String password) {
        Login user = loginRepo.findByEmailAndPassword(email, password);
        return user != null;  // Return true if user exists, false otherwise
    }

    // Optional method to register a new user (if applicable)
    public Login registerUser(String email, String password) {
        Login newUser = new Login(email, password);
        return loginRepo.save(newUser);  // Save the new user to the database
    }

    // Optional: Method to find a user by email
    public Login findUserByEmail(String email) {
        return loginRepo.findById(email).orElse(null);
    }
}
