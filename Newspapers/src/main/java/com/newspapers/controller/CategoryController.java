package com.newspapers.controller;

import com.newspapers.model.Category;
import com.newspapers.model.Newspaper;
import com.newspapers.service.CategoryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cate")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<List<Category>> addCategory() throws IOException {
        List<Category> list = new ArrayList<>();
        String link="https://tuoitre.vn";
        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
        Elements page = doc.select("div.footer__nav");
        for(Element element: page){
            Elements nav_link = element.getElementsByClass("nav-link");
            for (Element element1 : nav_link) {
                String name = element1.text();
                list.add(new Category(name));
            }
        }
        return new ResponseEntity<>(categoryService.addCategory(list), HttpStatus.CREATED);
    }
}
