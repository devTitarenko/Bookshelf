package com.titarenko.bookshelf.dto;

import com.titarenko.bookshelf.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoMapper {
    public BookDto BoToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setTitle(book.getTitle());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setGenre(book.getGenre().getName());
        return bookDto;
    }

    public Book DtoToBo(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setGenre(Book.Genre.valueOf(bookDto.getGenre()));
        return book;
    }
}
