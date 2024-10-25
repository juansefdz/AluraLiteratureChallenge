package com.juansefdz.LiterAlura.domain.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "books")

public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String description;
    private String language;
    private Integer pages;
    private String format;
    private String urlBook;
}
