package com.twg.springboot.api.service;

import java.util.List;
import java.util.Optional;

import com.twg.springboot.api.entity.Author;
import com.twg.springboot.api.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepo.findById(id);
    }

    @Override
    public Optional<Author> updateAuthor(Long id, Author updatedAuthor) {
        return authorRepo.findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            return authorRepo.save(author);
        });
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }
}
