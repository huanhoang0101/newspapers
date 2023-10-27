package com.newspapers.controller;

import com.newspapers.model.Newspaper;
import com.newspapers.service.NewspaperService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NewspaperController {
    @Autowired
    private NewspaperService newspaperService;

    @GetMapping("/get")
    public ResponseEntity<List<Newspaper>> getAll() {
        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    }

    //get list newspaper from web
    @Scheduled(fixedRate = 1000 * 60 * 30)
    @GetMapping("/add")
    public ResponseEntity<List<Newspaper>> get() throws IOException {
        String link = "https://tuoitre.vn";
        List<Newspaper> list = new ArrayList<>();
        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
        Elements page = doc.select("div[data-marked-zoneid=tto_home_stream1]");
        for (Element element : page) {
            Elements box_category_item = element.getElementsByClass("box-category-item");
            for (Element newspaper : box_category_item) {
                String title = newspaper.getElementsByTag("a").last().text();
                if (!newspaperService.isNewspaperExists(title)) {
                    String img = newspaper.getElementsByTag("img").first().attr("src");
                    String description = newspaper.getElementsByTag("p").last().text();
                    String linkToDetail = "https://tuoitre.vn/";
                    linkToDetail += newspaper.getElementsByTag("a").first().attr("href");
                    if (!title.isEmpty()) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = new Date();
                        String created_date = formatter.format(date);

                        org.jsoup.nodes.Document document = Jsoup.connect(linkToDetail).get();
                        String detailPage = document.select("div[itemprop=articleBody]").toString();
                        Newspaper n = new Newspaper(title, description, img, detailPage, created_date);

                        list.add(n);
                    }
                }
            }
        }
        return new ResponseEntity<>(newspaperService.addListNewspaper(list), HttpStatus.OK);
    }
}
