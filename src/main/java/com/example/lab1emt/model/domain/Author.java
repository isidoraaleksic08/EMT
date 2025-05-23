package com.example.lab1emt.model.domain;
import com.example.lab1emt.listeners.AuthorEntityListener;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@EntityListeners(AuthorEntityListener.class)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author( String name, String surname, Country country) {

        this.name = name;
        this.surname = surname;
        this.country = country;
    }
    public Author() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Country getCountry() {
        return country;
    }
}
