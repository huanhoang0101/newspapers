package com.newspapers.service;

import com.newspapers.model.Newspaper;
import com.newspapers.repository.NewspaperRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewspaperServiceImpl implements NewspaperService{
    @Autowired
    private NewspaperRepo newspaperRepo;
    @Override
    public List<Newspaper> getAll() {
        return newspaperRepo.findAll();
    }

    @Override
    public Newspaper add(Newspaper n) {
        return newspaperRepo.save(n);
    }

    @Override
    public List<Newspaper> addListNewspaper(List<Newspaper> list) {
        return newspaperRepo.saveAll(list);
    }

    @Override
    public Newspaper getDetail(int id) {
        return newspaperRepo.findById(id).get();
    }

    public boolean isNewspaperExists(String title) {
        return newspaperRepo.findNewspaperByTitle(title) == null ? false : true;
    }
}
