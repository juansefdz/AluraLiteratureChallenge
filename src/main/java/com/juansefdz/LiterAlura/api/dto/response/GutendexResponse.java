package com.juansefdz.LiterAlura.api.dto.response;

import com.juansefdz.LiterAlura.domain.entities.Book;
import lombok.Data;



import java.util.List;

@Data
public class GutendexResponse {
    private Integer count;
    private List<Book> results;
    private String next;
    private String previous;


}
