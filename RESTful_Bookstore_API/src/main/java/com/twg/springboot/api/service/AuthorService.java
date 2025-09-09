package com.twg.springboot.api.service;

	

import java.util.List;
import java.util.Optional;

import com.twg.springboot.api.entity.Author;




	public interface AuthorService {
	    List<Author> getAllAuthors();
	    Author createAuthor(Author author);
	    Optional<Author> getAuthorById(Long id);
	    Optional<Author> updateAuthor(Long id, Author updatedAuthor);
	    void deleteAuthor(Long id);
	}


