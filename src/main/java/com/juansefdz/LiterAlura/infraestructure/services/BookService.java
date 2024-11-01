package com.juansefdz.LiterAlura.infraestructure.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



import org.springframework.stereotype.Service;

import com.juansefdz.LiterAlura.api.dto.request.BookRequest;
import com.juansefdz.LiterAlura.api.dto.response.BookResponse;
import com.juansefdz.LiterAlura.api.dto.response.GutendexResponse;
import com.juansefdz.LiterAlura.domain.entities.Author;
import com.juansefdz.LiterAlura.domain.entities.Book;
import com.juansefdz.LiterAlura.domain.entities.SearchHistory;
import com.juansefdz.LiterAlura.domain.repositories.BookRepository;
import com.juansefdz.LiterAlura.domain.repositories.SearchHistoryRepository;
import com.juansefdz.LiterAlura.infraestructure.api.GutendexApi;



@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GutendexApi gutendexApi;
    private final SearchHistoryRepository searchHistoryRepository;

    public BookService(BookRepository bookRepository, AuthorService authorService, GutendexApi gutendexApi, SearchHistoryRepository searchHistoryRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.gutendexApi = gutendexApi;
        this.searchHistoryRepository = searchHistoryRepository;
    }

   
    public List<BookResponse> searchBooksByTitle(String title) {
        GutendexResponse response = gutendexApi.searchBooksByTitle(title);

        
        if (!response.getResults().isEmpty()) {
            Book apiBook = response.getResults().get(0); 
            String authorName = apiBook.getAuthors().isEmpty() ? "Unknown" : apiBook.getAuthors().get(0).getName();
            saveSearchHistory(apiBook.getTitle(), authorName);
        }

        
        return response.getResults().stream()
                .map(this::convertApiBookToBookResponse)
                .collect(Collectors.toList());
    }

    // Método para obtener todos los libros
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToBookResponse)
                .collect(Collectors.toList());
    }

    // Método para buscar libros por idioma
    public List<BookResponse> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language).stream()
                .map(this::convertToBookResponse)
                .collect(Collectors.toList());
    }

    // Método para guardar un libro en la base de datos
    public Book saveBook(Long id, BookRequest bookRequest,Integer birthYear, Integer deathYear) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());

        Author author = authorService.getOrCreateAuthorByName(id, bookRequest.getAuthor(), birthYear, deathYear);
        book.setAuthors(List.of(author));

        book.setLanguages(List.of(bookRequest.getLanguage()));

        return bookRepository.save(book);
    }

    // Método privado para guardar un libro en la base de datos
    private void saveSearchHistory(String bookTitle, String authorName) {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setTitle(bookTitle);
        searchHistory.setAuthor(authorName);
        searchHistory.setSearchDate(LocalDateTime.now());

        searchHistoryRepository.save(searchHistory);
    }

    // Método privado para convertir un libro de API a BookResponse
    private BookResponse convertApiBookToBookResponse(Book apiBook) {
        return BookResponse.builder()
                .id(apiBook.getId())
                .title(apiBook.getTitle())
                .authors(apiBook.getAuthors().stream().map(Author::getName).collect(Collectors.toList()))
                .languages(apiBook.getLanguages())
                .build();
    }

    // Método privado para convertir un libro a BookResponse
    private BookResponse convertToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authors(book.getAuthors().stream().map(Author::getName).collect(Collectors.toList()))
                .languages(book.getLanguages())
                .build();
    }
}
