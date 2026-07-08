package com.practice.springboot.service;

import com.practice.springboot.entity.User;
import com.practice.springboot.repository.UserRepository;
import com.practice.springboot.dto.LoginRequest;
import com.practice.springboot.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public LoginService(UserRepository userRepository,
                        PasswordEncoder passwordEncoder,
                        AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    public User createUser(RegisterRequest request){
        String username=request.getUsername();
        String password=request.getPassword();

        if(username == null || password == null || username.isBlank()||password.isBlank()){
            throw new RuntimeException("username and password fields are mandatory");
        }

        if(userRepository.findByUsername(username).isPresent()){
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return user;
    }

    public User loginUser(LoginRequest request){
        String username=request.getUsername();
        String password=request.getPassword();

        if(username == null || password == null || username.isBlank()||password.isBlank()){
            throw new RuntimeException("username and password fields are mandatory");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user;
    }

    public static void main(String[] args) {
        System.out.println("Monx");
    }
}
