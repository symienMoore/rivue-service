package com.sam.rivueservices.controllers;

import com.sam.rivueservices.entities.AuthRequest;
import com.sam.rivueservices.entities.User;
import com.sam.rivueservices.repositories.UserRepository;
import com.sam.rivueservices.services.UserService;
import com.sam.rivueservices.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private User user;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private AuthenticationManager auth;

    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public void register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @PostMapping("/login")
    public String logInUser(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            auth.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username or password....sorry  " + ex);
        }
        return jwt.generateToken(authRequest.getUsername());
    }


}

