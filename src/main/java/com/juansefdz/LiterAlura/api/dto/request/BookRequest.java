package com.juansefdz.LiterAlura.api.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequest {

    private String title;
    private String author;
    private String description;
    private String language;
    private Integer pages;
    private String format;
    private String urlBook;

}
