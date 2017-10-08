package com.titarenko.bookshelf.service;

import com.titarenko.bookshelf.model.Author;
import com.titarenko.bookshelf.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository repository;

    public Author find(Integer id) {
        return repository.findOne(id);
    }

    public Iterable<Author> findAll() {
        return repository.findAll();
    }

    public void save(Author author) {
        repository.save(author);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}