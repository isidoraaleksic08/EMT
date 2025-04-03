package com.example.lab1emt.repository;

import com.example.lab1emt.model.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findTop10ByOrderByDateDesc();

}
