package com.example.lab1emt.service.application.impl;

import com.example.lab1emt.dto.CreateUserDto;
import com.example.lab1emt.dto.DisplayUserDto;
import com.example.lab1emt.dto.LoginResponseDto;
import com.example.lab1emt.dto.LoginUserDto;
import com.example.lab1emt.model.domain.User;
import com.example.lab1emt.repository.UserRepository;
import com.example.lab1emt.security.JwtHelper;
import com.example.lab1emt.service.application.UserApplicationService;
import com.example.lab1emt.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserRepository userRepository, UserService userService, JwtHelper jwtHelper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtHelper = jwtHelper;
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
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        );

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDto(token));
    }

    public List<DisplayUserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(DisplayUserDto::from)
                .toList();
    }
    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }
}
