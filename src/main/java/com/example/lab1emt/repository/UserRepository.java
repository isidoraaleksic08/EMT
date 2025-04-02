package com.example.lab1emt.repository;

import com.example.lab1emt.model.domain.User;
import com.example.lab1emt.model.enumerations.Role;
import com.example.lab1emt.model.projection.UserProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    List<UserProjection> findAllByRole(Role role);

    @Query("SELECT u FROM User u")
    List<UserProjection> findAllProjected();

}

