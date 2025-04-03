package com.example.lab1emt.config;

import com.example.lab1emt.model.domain.*;
import com.example.lab1emt.model.enumerations.Role;
import com.example.lab1emt.repository.AuthorRepository;
import com.example.lab1emt.repository.BookRepository;
import com.example.lab1emt.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.lab1emt.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private final PasswordEncoder passwordEncoder;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;
   private final UserRepository userRepository;
    public DataInitializer(PasswordEncoder passwordEncoder, AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
        this.userRepository = userRepository;
    }

    private final List<Author> authors = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();
    private final List<Country> countries = new ArrayList<>();
    private final List<Category> categories = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Initialize Categories
        categories.add(Category.FANTASY);
        categories.add(Category.BIOGRAPHY);
        categories.add(Category.DRAMA);
        categories.add(Category.NOVEL);


        Country country1 = new Country( "Country1", "Continent1");
        Country country2 = new Country( "Country2", "Continent2");
        Country country3 = new Country( "Country3", "Continent3");

        countries.addAll(List.of(country1, country2, country3));
        countryRepository.saveAll(countries);


        Author author1 = new Author( "Name1", "Surname1", country2);
        Author author2 = new Author( "Name2", "Surname2", country3);
        Author author3 = new Author( "Name3", "Surname3", country1);

        authors.addAll(List.of(author1, author2, author3));
        authorRepository.saveAll(authors);


        books.add(new Book( "Book1", categories.get(2), author2, 3, LocalDateTime.of(2024,5,8,5,15)));
        books.add(new Book( "Book2", categories.get(3), author3, 6,LocalDateTime.of(2024,3,2,4,12)));
        books.add(new Book( "Book3", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book4", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book5", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book6", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book7", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book8", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book9", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book10", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));
        books.add(new Book( "Book11", categories.get(1), author1, 2,LocalDateTime.of(2025,3,4,1,23)));

        bookRepository.saveAll(books);

        userRepository.save(new User(
                "at",
                passwordEncoder.encode("at"),
                "Ana",
                "Todorovska",
                Role.ROLE_Librarian
        ));
        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "User",
                "User",
                Role.ROLE_USER
        ));

    }
}
