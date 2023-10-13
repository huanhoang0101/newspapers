package com.newspapers.service;

import com.newspapers.model.Newspaper;
import com.newspapers.model.NewspaperDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NewspaperDetailService {
    NewspaperDetail getContent(int id);
    public NewspaperDetail addContent(NewspaperDetail detail);
}
