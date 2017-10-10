package com.titarenko.bookshelf.dto;

import com.titarenko.bookshelf.model.Author;
import com.titarenko.bookshelf.model.BaseObject;
import com.titarenko.bookshelf.model.Book;
import com.titarenko.bookshelf.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BookDtoMapper {

    @Autowired
    private AuthorService authorService;

    public BookDto BoToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setGenre(book.getGenre().getName());
        if (book.getAuthors() != null) {
            Map<Integer, String> authors = new HashMap<>();
            for (Author author : book.getAuthors()) {
                authors.put(author.getId(), author.getFirstName() + " " + author.getLastName());
            }
            bookDto.setAuthors(authors);
        }
        return bookDto;
    }

    public Book DtoToBo(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setGenre(Book.Genre.valueOf(bookDto.getGenre()));
        if (bookDto.getAuthors() != null) {
            book.setAuthors(bookDto.getAuthors().keySet().stream()
                    .map(id -> authorService.find(id)).collect(Collectors.toList()));
        }
        return book;
    }
}