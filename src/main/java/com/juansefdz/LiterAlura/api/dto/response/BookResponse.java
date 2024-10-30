package com.juansefdz.LiterAlura.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String description;
    private String language;
    private Integer pages;
    private String format;
    private String urlBook;

    @Override
    public String toString() {
        return "------------------------------\n" +
                "Book Details:\n" +
                "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Description: " + description + "\n" +
                "Language: " + language + "\n" +
                "Pages: " + pages + "\n" +
                "Format: " + format + "\n" +
                "URL: " + urlBook + "\n" +


                "------------------------------";
    }
}
