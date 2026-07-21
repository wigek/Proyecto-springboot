package com.proyecto.personal.demo.dto;

public record UserRegisterRequest(
    String name,
    String lastName,
    String email,
    String password
){
}
