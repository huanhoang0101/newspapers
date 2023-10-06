package com.newspapers.repository;

import com.newspapers.model.NewspaperDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewspaperDetailRepo extends JpaRepository<NewspaperDetail, Integer> {
}
