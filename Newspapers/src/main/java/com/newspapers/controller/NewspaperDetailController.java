package com.newspapers.controller;

import com.newspapers.model.Newspaper;
import com.newspapers.model.NewspaperDetail;
import com.newspapers.service.NewspaperDetailService;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api/d")
public class NewspaperDetailController {
    @Autowired
    private NewspaperDetailService newspaperDetailService;

    //    @GetMapping("/get")
//    public ResponseEntity<List<Newspaper>> get2() throws IOException {
//        String link = "https://tuoitre.vn/sieu-thi-giam-gia-manh-cac-mat-hang-ban-chay-202310060755421.htm";
//        org.jsoup.nodes.Document doc = Jsoup.connect(link).get();
//        Elements page = doc.select("div[itemprop=articleBody]");
//        System.out.println(page);
//        return new ResponseEntity<>(newspaperService.getAll(), HttpStatus.OK);
    @GetMapping ("/get/{id}")
    public ResponseEntity<NewspaperDetail> getDetailById(@PathVariable("id") int id) {
        return new ResponseEntity<>(newspaperDetailService.getContent(id), HttpStatus.OK);
    }
}
