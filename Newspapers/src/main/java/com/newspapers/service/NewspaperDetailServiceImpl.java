package com.newspapers.service;

import com.newspapers.model.NewspaperDetail;
import com.newspapers.repository.NewspaperDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewspaperDetailServiceImpl implements NewspaperDetailService{
    @Autowired
    private NewspaperDetailRepo newspaperDetailRepo;
    @Override
    public NewspaperDetail getContent(int id) {
        return newspaperDetailRepo.findById(id).get();
    }
}
