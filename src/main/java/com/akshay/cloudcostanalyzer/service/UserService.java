package com.akshay.cloudcostanalyzer.service;

import com.akshay.cloudcostanalyzer.dto.AuthResponse;
import com.akshay.cloudcostanalyzer.dto.LoginRequest;
import com.akshay.cloudcostanalyzer.dto.LoginResponse;
import com.akshay.cloudcostanalyzer.dto.RegisterRequest;
import com.akshay.cloudcostanalyzer.entity.User;
import com.akshay.cloudcostanalyzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<AuthResponse> register(RegisterRequest request) {

        Optional<User> existingUser =
                userRepository.findByEmail(request.getEmail());

        if(existingUser.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse("Email already exists"));
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        //user.setPassword(request.getPassword());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);

        return ResponseEntity.ok(
                new AuthResponse("User registered successfully"));
    }

    public ResponseEntity<AuthResponse> login(LoginRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {

            //throw new RuntimeException("User not found");
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse("User Not Found"));
        }

        User user = optionalUser.get();

       // if (!user.getPassword().equals(request.getPassword()))

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        ))
        {
           // throw new RuntimeException("Invalid password");
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse("Invalid password"));
        }


        return ResponseEntity
                .ok()
                .body(new AuthResponse("Usr logged in Successfully"));
    }
}
