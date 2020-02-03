package com.techsoltrackers.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "BOOK_INFO")
@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOK_ID")
    Long bookId;

    @NotBlank
    @Column(name="BOOK_NAME")
    String bookName;

    @NotBlank
    @Column(name="AUTHOR")
    String author;

    @Column(name="DESCRIPTION")
    String description;

    @Column(name="AVG_RATING")
    double avgRating;
}
