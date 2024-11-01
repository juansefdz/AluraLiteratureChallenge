package com.juansefdz.LiterAlura.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juansefdz.LiterAlura.domain.entities.SearchHistory;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
   
}