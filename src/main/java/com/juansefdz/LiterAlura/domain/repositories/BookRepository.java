package com.juansefdz.LiterAlura.domain.repositories;


import com.juansefdz.LiterAlura.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query(value = "SELECT * FROM book b WHERE :language IN (b.languages)", nativeQuery = true)
    List<Book> findByLanguage(String language);
    
}
