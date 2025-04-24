package com.example.lab1emt.dto;

public class BooksByAuthorView {

    private Long authorId;
    private String name;
    private String surname;
    private Long bookCount;

    public BooksByAuthorView(Long authorId, String name, String surname, Long bookCount) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.bookCount = bookCount;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getBookCount() {
        return bookCount;
    }
}
