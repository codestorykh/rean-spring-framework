package com.rean.repository;

import com.rean.model.PageClazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageClazzRepository extends JpaRepository<PageClazz, Long> {
}
