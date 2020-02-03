package com.techsoltrackers.controller;

import com.techsoltrackers.domain.dto.BookInfo;
import com.techsoltrackers.services.BookCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookCatalogController {
    @Autowired
    BookCatalogService bookCatalogService;

    @PostMapping("/bookInfo")
    public ResponseEntity<BookInfo> createBookInfo(@Valid @RequestBody BookInfo bookInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookCatalogService.createBookInfo(bookInfo));
    }

    //@GetMapping("/bookinfo")

    //@GetMapping("/bookInfos")
    @RequestMapping(value = "/bookInfos", method = RequestMethod.GET)
    public ResponseEntity<List<BookInfo>> getAllBookInfo() {
        return ResponseEntity.ok().body(bookCatalogService.getAllBookInfo());
    }

    //@GetMapping("/bookinfo/{id}")

    //@GetMapping("/bookinfo/{id}")
    @RequestMapping(value = "/bookinfo/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookInfo> getBookInfoById(@PathVariable(value = "id") Long bookInfoId) {
        return ResponseEntity.ok().body(bookCatalogService.getBookInfoById(bookInfoId));
    }

    //@PostMapping("/bookinfo/{id}")
    //@PostMapping("/bookinfo/{id}")
    @RequestMapping(value = "/bookinfo/{id}", method = RequestMethod.POST)
    public ResponseEntity<BookInfo> updateBookInfo(@PathVariable(value = "id") Long bookInfoId,
                                           @Valid @RequestBody BookInfo bookInfoDetails) {

        return ResponseEntity.ok().body(bookCatalogService.updateBookInfo(bookInfoId,bookInfoDetails));
    }
}
