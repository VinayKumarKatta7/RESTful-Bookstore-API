package com.twg.springboot.api.service;

	
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;

import com.twg.springboot.api.entity.Book;

import java.util.Optional;
	
	

	public interface BookService {
	    Page<Book> getAllBooks(String title, Pageable pageable);
	    Book createBook(Book book);
	    Optional<Book> getBookById(Long id);
	    Optional<Book> updateBook(Long id, Book updatedBook);
	    void deleteBook(Long id);
	    
	    
}

	
	
	

