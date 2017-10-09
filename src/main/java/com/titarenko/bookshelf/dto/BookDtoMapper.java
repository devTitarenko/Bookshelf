package com.titarenko.bookshelf.dto;

import com.titarenko.bookshelf.model.BaseObject;
import com.titarenko.bookshelf.model.Book;
import com.titarenko.bookshelf.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            bookDto.setAuthors(book.getAuthors().stream().map(BaseObject::getId).collect(Collectors.toList()));
        }
        return bookDto;
    }

    public Book DtoToBo(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setGenre(Book.Genre.valueOf(bookDto.getGenre()));
        if (bookDto.getAuthors() != null) {
            book.setAuthors(bookDto.getAuthors().stream()
                    .map(id -> authorService.find(id)).collect(Collectors.toList()));
        }
        return book;
    }
}