package com.juansefdz.LiterAlura.api.dto.response;

import java.util.List;

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
    private List<String> authors; 
    private String description; 
    private List<String> languages; 

    @Override
    public String toString() {
        return "------------------------------\n" +
                "Book Details:\n" +
                "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Authors: " + String.join(", ", authors) + "\n" + 
                "Languages: " + String.join(", ", languages) + "\n"; 
    }
}