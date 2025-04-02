package com.example.lab1emt.service.application;

import com.example.lab1emt.dto.CreateUserDto;
import com.example.lab1emt.dto.DisplayUserDto;
import com.example.lab1emt.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);

}
