package com.example.lab1emt.service;

import com.example.lab1emt.model.Book;
import com.example.lab1emt.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> create(String name, Category category, Long authorId, Integer availableCopies);
    Optional<Book> findById(Long id);

    Optional<Book> update(Long id,String name, Category category, Long authorId, Integer availableCopies);
    void deleteById(Long id);
    Optional<Book> markBook(Long id);
}
