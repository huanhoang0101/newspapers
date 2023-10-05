package com.newspapers.controller;

import com.newspapers.model.Newspaper;
import com.newspapers.service.NewspaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class NewspaperController {
    @Autowired
    private NewspaperService newspaperService;

    @GetMapping("/get")
    public ResponseEntity<List<Newspaper>> getAll() {
        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Newspaper> add(@RequestBody Newspaper n) {
        return new ResponseEntity<>(newspaperService.add(n), HttpStatus.CREATED);
    }
}
