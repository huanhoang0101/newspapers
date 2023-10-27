package com.newspapers.controller;

import com.newspapers.model.Newspaper;
import com.newspapers.service.NewspaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/detail")
public class NewspaperDetailController {

    @Autowired
    private NewspaperService newspaperService;

    //get newspaper from db
    @GetMapping ("/get/{id}")
    public ResponseEntity<Newspaper> getDetailById(@PathVariable("id") int id) {
        return new ResponseEntity<>(newspaperService.getDetail(id), HttpStatus.OK);
    }
}
