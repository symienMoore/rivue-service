package com.sam.rivueservices.controllers;

import com.sam.rivueservices.entities.AuthRequest;
import com.sam.rivueservices.entities.AuthResponse;
import com.sam.rivueservices.entities.User;
import com.sam.rivueservices.repositories.UserRepository;
import com.sam.rivueservices.services.UserService;
import com.sam.rivueservices.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
    public void register(@RequestBody User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        service.addUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logInUser(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            auth.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username or password....sorry  " + ex);
        }
        String token =  jwt.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }


}

