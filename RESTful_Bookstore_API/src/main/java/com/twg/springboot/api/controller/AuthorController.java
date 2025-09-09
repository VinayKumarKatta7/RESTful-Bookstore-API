package com.twg.springboot.api.controller;





	
	
	
	
	
	
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.twg.springboot.api.entity.Author;
import com.twg.springboot.api.service.AuthorService;

import java.util.List;

	@RestController
	@RequestMapping("/api/authors")
	public class AuthorController {

	    private final AuthorService authorService;

	    // Constructor Injection
	    public AuthorController(AuthorService authorService) {
	        this.authorService = authorService;
	    }

	    // Get all authors
	    @GetMapping
	    public List<Author> getAll() {
	        return authorService.getAllAuthors();
	    }

	    // Create new author
	    @PostMapping
	    public Author create(@RequestBody Author author) {
	        return authorService.createAuthor(author);
	    }

	    // Get author by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Author> getById(@PathVariable Long id) {
	        return authorService.getAuthorById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Update author
	    @PutMapping("/{id}")
	    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author updatedAuthor) {
	        return authorService.updateAuthor(id, updatedAuthor)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Delete author
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        authorService.deleteAuthor(id);
	        return ResponseEntity.noContent().build();
	    }
	}

	
	
	
	

