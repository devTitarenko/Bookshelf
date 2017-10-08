package com.titarenko.bookshelf.service;

import com.titarenko.bookshelf.model.Book;
import com.titarenko.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Book find(Integer id) {
        return repository.findOne(id);
    }

    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    public void save(Book book) {
        repository.save(book);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}