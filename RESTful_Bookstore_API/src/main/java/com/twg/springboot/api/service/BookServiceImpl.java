package com.twg.springboot.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twg.springboot.api.entity.Book;
import com.twg.springboot.api.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public Page<Book> getAllBooks(String title, Pageable pageable) {
        if (title != null) {
            return bookRepo.findByTitleContaining(title, pageable);
        }
        return bookRepo.findAll(pageable);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return bookRepo.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setPrice(updatedBook.getPrice());
            book.setAuthor(updatedBook.getAuthor());
            return bookRepo.save(book);
        });
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}

