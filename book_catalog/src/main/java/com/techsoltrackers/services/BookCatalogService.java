package com.techsoltrackers.services;

import com.techsoltrackers.domain.dto.BookInfo;

import java.util.List;

public interface BookCatalogService {
    BookInfo createBookInfo(BookInfo bookInfo);
    List<BookInfo> getAllBookInfo();
    BookInfo getBookInfoById(Long bookInfoId);
    BookInfo updateBookInfo(Long bookInfoId,BookInfo bookInfoDetails);
}
