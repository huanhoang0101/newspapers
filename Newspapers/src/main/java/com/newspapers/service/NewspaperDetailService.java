package com.newspapers.service;

import com.newspapers.model.NewspaperDetail;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface NewspaperDetailService {
    NewspaperDetail getContent(int id);
}
