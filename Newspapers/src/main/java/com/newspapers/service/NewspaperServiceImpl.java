package com.newspapers.service;

import com.newspapers.model.Newspaper;
import com.newspapers.repository.NewspaperRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
}
