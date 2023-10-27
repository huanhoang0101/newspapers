package com.newspapers.service;

import com.newspapers.model.Newspaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewspaperService {
    public List<Newspaper> getAll();
    public Newspaper add (Newspaper n);
    public List<Newspaper> addListNewspaper(List<Newspaper> list);
    public Newspaper getDetail(int id);
    public boolean isNewspaperExists(String title);
}
