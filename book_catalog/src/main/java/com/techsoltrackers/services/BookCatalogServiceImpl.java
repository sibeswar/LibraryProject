package com.techsoltrackers.services;

import com.techsoltrackers.domain.dto.BookInfo;
import com.techsoltrackers.persistance.dao.BookInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCatalogServiceImpl implements BookCatalogService {
    @Autowired
    BookInfoDAO bookInfoDAO;

    @Override
    public BookInfo createBookInfo(BookInfo bookInfo) {
        return bookInfoDAO.createBookInfo(bookInfo);
    }

    @Override
    public List<BookInfo> getAllBookInfo() {
        return bookInfoDAO.getAllBookInfo();
    }

    @Override
    public BookInfo getBookInfoById(Long bookInfoId) {
        return bookInfoDAO.getBookInfoById(bookInfoId);
    }

    @Override
    public BookInfo updateBookInfo(Long bookInfoId, BookInfo bookInfoDetails) {
        return bookInfoDAO.updateBookInfo(bookInfoId,bookInfoDetails);
    }
}
