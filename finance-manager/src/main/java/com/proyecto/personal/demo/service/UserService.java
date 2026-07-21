package com.proyecto.personal.demo.service;

import com.proyecto.personal.demo.dto.UserRegisterRequest;
import com.proyecto.personal.demo.entity.User;
import com.proyecto.personal.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        User user = new User();
        user.setName(request.name());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPassword(request.password()); // ⚠️ sin encriptar todavía, ver nota abajo
        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}