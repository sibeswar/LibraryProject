package com.techsoltrackers.persistance.dao;

import com.techsoltrackers.domain.dto.BookInfo;
import com.techsoltrackers.domain.entity.BookInfoEntity;
import com.techsoltrackers.persistance.repository.BookInfoRepository;
import com.techsoltrackers.utility.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookInfoDAO {

    @Autowired
    BookInfoRepository bookInfoRepository;

    public BookInfo createBookInfo(BookInfo bookInfo) {
        BookInfoEntity bookInfoEntity= ObjectMapperUtils.map(bookInfo,BookInfoEntity.class);
        bookInfoEntity=bookInfoRepository.save(bookInfoEntity);
        BookInfo bookInfoResponse=ObjectMapperUtils.map(bookInfoEntity,BookInfo.class);
        return bookInfoResponse;
    }

    public List<BookInfo> getAllBookInfo() {

        List<BookInfoEntity> bookInfoEntityList=bookInfoRepository.findAll();
        List<BookInfo> bookInfoResponses=ObjectMapperUtils.mapAll(bookInfoEntityList,BookInfo.class);
        return bookInfoResponses;
    }

    public BookInfo getBookInfoById(Long bookInfoId) {
        BookInfoEntity bookInfoEntity=bookInfoRepository.findById(bookInfoId).orElse(new BookInfoEntity());
        BookInfo bookInfoRes=ObjectMapperUtils.map(bookInfoEntity,BookInfo.class);
        return bookInfoRes;
    }

    public BookInfo updateBookInfo(Long bookInfoId, BookInfo bookInfoDetails) {
        BookInfo bookInfo=getBookInfoById(bookInfoId);
        BookInfo bookInfoRes=null;
        if(bookInfo!=null){
            bookInfo.setAvgRating(bookInfoDetails.getAvgRating());
            bookInfo.setDescription(bookInfoDetails.getDescription());
            BookInfoEntity bookInfoEntity=ObjectMapperUtils.map(bookInfo,BookInfoEntity.class);
            bookInfoEntity=bookInfoRepository.save(bookInfoEntity);
            bookInfoRes=ObjectMapperUtils.map(bookInfoEntity,BookInfo.class);
        }
        return bookInfoRes;
    }
}
