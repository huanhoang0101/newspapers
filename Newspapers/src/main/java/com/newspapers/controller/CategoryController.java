package com.newspapers.controller;

import com.newspapers.model.Category;
import com.newspapers.model.Newspaper;
import com.newspapers.response.ResponseHandler;
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
    public ResponseEntity<Object> getAllCategory() {
        try {
            List<Category> c;
            c = categoryService.getAllCategory();
            return ResponseHandler.responseSuccessBuilder(true,
                    HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.responseErrorBuilder(false,
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/add")
    public ResponseEntity<Object> addCategory() throws IOException {
        List<Category> list = new ArrayList<>();
        String link="https://tuoitre.vn";
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
            Elements page = doc.select("div.footer__nav");
            for(Element element: page){
                Elements nav_link = element.getElementsByClass("nav-link");
                for (Element element1 : nav_link) {
                    String name = element1.text();
                    list.add(new Category(name));
                }
            }
            return ResponseHandler.responseSuccessBuilder(true,
                    HttpStatus.CREATED,
                    categoryService.addCategory(list));
        } catch (Exception e) {
            return ResponseHandler.responseErrorBuilder(false,
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
