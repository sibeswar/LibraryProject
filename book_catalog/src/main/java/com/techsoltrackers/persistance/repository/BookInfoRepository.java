package com.techsoltrackers.persistance.repository;

import com.techsoltrackers.domain.entity.BookInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfoEntity, Long> {
}
