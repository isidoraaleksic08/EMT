package com.example.lab1emt.service.domain.impl;

import com.example.lab1emt.model.domain.User;
import com.example.lab1emt.model.enumerations.Role;
import com.example.lab1emt.model.exeptions.InvalidArgumentsException;
import com.example.lab1emt.model.exeptions.InvalidUsernameOrPasswordException;
import com.example.lab1emt.model.exeptions.InvalidUserCredentialsException;
import com.example.lab1emt.model.exeptions.PasswordsDoNotMatchException;
import com.example.lab1emt.model.exeptions.UsernameAlreadyExistsException;
import com.example.lab1emt.repository.UserRepository;
import com.example.lab1emt.service.domain.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User register(
            String username,
            String password,
            String repeatPassword,
            String name,
            String surname,
            Role userRole
    ) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword)) throw new PasswordsDoNotMatchException();
        if (userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username, passwordEncoder.encode(password), name, surname, userRole);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                InvalidUserCredentialsException::new);
    }
}