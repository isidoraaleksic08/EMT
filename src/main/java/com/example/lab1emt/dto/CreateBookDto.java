package com.example.lab1emt.dto;

import com.example.lab1emt.model.domain.Author;
import com.example.lab1emt.model.domain.Book;
import com.example.lab1emt.model.domain.Category;

public record CreateBookDto(String name, Category category, Long authorId, int availableCopies) {
    public Book toBook( Author author){
        return new Book(name,category,author,availableCopies);
    }
}
