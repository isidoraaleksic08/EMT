package com.example.lab1emt.service.impl;

import com.example.lab1emt.model.Author;
import com.example.lab1emt.model.exeptions.InvalidAuthorId;
import com.example.lab1emt.model.exeptions.InvalidCountryId;
import com.example.lab1emt.repository.AuthorRepository;
import com.example.lab1emt.service.AuthorService;
import com.example.lab1emt.service.CountryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> create(String name, String surname, Long countryId) {
        return Optional.of(authorRepository.save(new Author(name, surname, countryService.findById(countryId).orElseThrow(InvalidCountryId::new))));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(this.authorRepository.findById(id).orElseThrow(InvalidAuthorId::new));    }

    @Override
    public Optional<Author> update(Long id, String name, String surname, Long countryId) {
        Author author = findById(id).orElseThrow(InvalidAuthorId::new);
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(countryService.findById(countryId).orElseThrow(InvalidCountryId::new));
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
