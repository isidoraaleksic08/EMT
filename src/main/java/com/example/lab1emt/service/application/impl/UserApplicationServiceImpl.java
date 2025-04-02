package com.example.lab1emt.service.application.impl;

import com.example.lab1emt.dto.CreateUserDto;
import com.example.lab1emt.dto.DisplayUserDto;
import com.example.lab1emt.dto.LoginUserDto;
import com.example.lab1emt.model.domain.User;
import com.example.lab1emt.service.application.UserApplicationService;
import com.example.lab1emt.service.domain.UserService;
import com.example.lab1emt.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;

    public UserApplicationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
        return Optional.of(DisplayUserDto.from(userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        )));
    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }
}
