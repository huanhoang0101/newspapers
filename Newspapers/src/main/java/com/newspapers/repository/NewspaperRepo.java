package com.newspapers.repository;

import com.newspapers.model.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewspaperRepo extends JpaRepository<Newspaper, Integer> {
    Newspaper findNewspaperByTitle(String title);
}
