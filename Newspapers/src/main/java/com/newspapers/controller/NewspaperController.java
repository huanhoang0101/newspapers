package com.newspapers.controller;

import com.newspapers.model.Newspaper;
import com.newspapers.service.NewspaperService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
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

    @GetMapping("/ok")
    public ResponseEntity<List<Newspaper>> get() throws IOException {
        String link = "https://tuoitre.vn";
        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
        Elements page = doc.select("div[data-marked-zoneid=tto_home_stream1]");
        for (Element element : page) {
            Elements box_category_item = element.getElementsByClass("box-category-item");
            for (Element newspaper : box_category_item) {
                String title = newspaper.getElementsByTag("a").last().text();
                String img = newspaper.getElementsByTag("img").first().attr("src");
                String description = newspaper.getElementsByTag("p").last().text();
                if (!title.isEmpty()) {
                    System.out.println("===========");
                    System.out.println(title);
                    System.out.println(description);
                    System.out.println(img);
                }
            }
        }
        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/ok1")
    public ResponseEntity<List<Newspaper>> get1() throws IOException {
        String link = "https://tuoitre.vn";
        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
        Elements page = doc.select("div.footer__nav");
        for (Element element1 : page) {
            Elements nav_link = element1.getElementsByClass("nav-link");
            for (Element element : nav_link) {
                System.out.println(element.text());
                System.out.println("======");
            }
        }
        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/ok2")
    public ResponseEntity<List<Newspaper>> get2() throws IOException {
        String link = "https://tuoitre.vn/sieu-thi-giam-gia-manh-cac-mat-hang-ban-chay-202310060755421.htm";
        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
        Elements page = doc.select("div[itemprop=articleBody]");
        System.out.println(page);
        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    }
}
