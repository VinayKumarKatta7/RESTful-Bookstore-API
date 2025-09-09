package com.twg.springboot.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.springboot.api.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	Page<Book> findByTitleContaining(String title, Pageable pageable);

}
