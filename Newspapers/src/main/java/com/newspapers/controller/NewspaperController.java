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
        int dem = 0;
        String link="https://tuoitre.vn";
        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
        Elements page = doc.select("div[data-marked-zoneid=tto_home_stream1]");
        for (Element element: page){
            Elements box_category_item = element.getElementsByClass("box-category-item");
            for (Element newspaper: box_category_item) {
                String title = newspaper.getElementsByTag("a").last().text();
                String img = newspaper.getElementsByTag("img").first().attr("src");
                String description = newspaper.getElementsByTag("p").last().text();
                if(!title.isEmpty()) {
                    System.out.println("===========");
                    System.out.println(title);
                    System.out.println(description);
                    System.out.println(img);
                    dem++;
                }
            }
        }
        System.out.println(dem);
       // Elements page = doc.select("p[data-type=sapo class=box-category-sapo need-trimline rel=3]");
        //Elements page = doc.select("a[class=box-category-link-title data-type=0]");
        //Element page = doc.select("div[class=box-category-item data-order=0]").first();
        //Element page = doc.select("div[class=box-category-item data-order=0 data-id=20231005062154193]").first();
//        Elements page = doc.select("div[class=box-category-item]");
//        for (Element element: page) {
//            Element pageTitle = element.getElementsByTag("a").last();
//            if(!pageTitle.text().isEmpty()){
//                System.out.println("===========");
//                System.out.println(pageTitle.text());
//                dem++;
//            }
//        }
//        System.out.println(dem);
//        Element pageTitle = page.getElementsByTag("a").first();
//        if(pageTitle != null)
//            System.out.println(pageTitle.text());
//        else
//            System.out.println("wrong");
        //System.out.println(page.text());
        //Elements page = doc.select("title");
//        for (int i=1; 1<page.size();i++) {
//            System.out.println(page.get(i).text());
//            System.out.println("exxxx====");
//        }
        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    }
}
