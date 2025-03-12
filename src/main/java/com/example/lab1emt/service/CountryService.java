package com.example.lab1emt.service;
import com.example.lab1emt.model.Country;

import java.util.List;
import java.util.Optional;


public interface CountryService {
    List<Country> findAll();
    Optional<Country> update(Long id,String name,String continent);
    Optional<Country> create(String name,String continent);
    Optional<Country> findById(Long id);

    void deleteById(Long id);
}
