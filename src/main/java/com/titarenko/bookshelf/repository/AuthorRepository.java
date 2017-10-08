package com.titarenko.bookshelf.repository;

import com.titarenko.bookshelf.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
