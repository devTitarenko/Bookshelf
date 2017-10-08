package com.titarenko.bookshelf.repository;

import com.titarenko.bookshelf.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
