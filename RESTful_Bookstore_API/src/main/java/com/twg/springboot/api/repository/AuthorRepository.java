package com.twg.springboot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.springboot.api.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	

}
