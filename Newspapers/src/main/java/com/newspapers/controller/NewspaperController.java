package com.newspapers.controller;

import com.newspapers.model.Newspaper;
import com.newspapers.service.NewspaperDetailService;
import com.newspapers.service.NewspaperService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/api")
public class NewspaperController {
    //private static final Logger LOGGER = LoggerFactory.getLogger(NewspaperController.class);
    @Autowired
    private NewspaperService newspaperService;
    @Autowired
    private NewspaperDetailService newspaperDetailService;

    @GetMapping("/get")
    public ResponseEntity<List<Newspaper>> getAll() {
        //LOGGER.info("LoggerService done");
        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    }

    //get list newspaper from web
    @GetMapping("/ok")
    public ResponseEntity<List<Newspaper>> get() throws IOException {
        String link = "https://tuoitre.vn";
        List<Newspaper> list = new ArrayList<>();
        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
        Elements page = doc.select("div[data-marked-zoneid=tto_home_stream1]");
        for (Element element : page) {
            Elements box_category_item = element.getElementsByClass("box-category-item");
            for (Element newspaper : box_category_item) {
                String title = newspaper.getElementsByTag("a").last().text();
                String img = newspaper.getElementsByTag("img").first().attr("src");
                String description = newspaper.getElementsByTag("p").last().text();
                String linkToDetail = "https://tuoitre.vn/";
                linkToDetail += newspaper.getElementsByTag("a").first().attr("href");
                if (!title.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    String created_date = formatter.format(date);

                    //do some thing
                    org.jsoup.nodes.Document document = Jsoup.connect(linkToDetail).get();
                    String detailPage = document.select("div[itemprop=articleBody]").toString();
                    Newspaper n = new Newspaper(title, description, img, detailPage, created_date);

                    list.add(n);
                }
            }
        }
        return new ResponseEntity<>(newspaperService.addListNewspaper(list), HttpStatus.OK);
    }

    //
//    @GetMapping("/ok1")
//    public ResponseEntity<List<Newspaper>> get1() throws IOException {
//        String link = "https://tuoitre.vn";
//        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
//        Elements page = doc.select("div.footer__nav");
//        for (Element element1 : page) {
//            Elements nav_link = element1.getElementsByClass("nav-link");
//            for (Element element : nav_link) {
//                System.out.println(element.text());
//                System.out.println("======");
//            }
//        }
//        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
//    }

    //get detail newspaper from web
//    @GetMapping("/ok2")
//    public ResponseEntity<List<Newspaper>> get2() throws IOException {
//        String link = "https://tuoitre.vn/sieu-thi-giam-gia-manh-cac-mat-hang-ban-chay-202310060755421.htm";
//        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
//        Elements page = doc.select("div[itemprop=articleBody]");
//        System.out.println(page);
//        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
//    }
}
