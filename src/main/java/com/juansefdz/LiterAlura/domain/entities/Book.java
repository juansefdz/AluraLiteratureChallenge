package com.juansefdz.LiterAlura.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Author> authors;

}
