package com.techsoltrackers.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class BookInfo {
    Long bookId;
    String bookName;
    String author;
    String description;
    double avgRating;
}
