package com.titarenko.bookshelf.dto;

import com.titarenko.bookshelf.model.Author;
import com.titarenko.bookshelf.model.Book;
import com.titarenko.bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AuthorDtoMapper {

    @Autowired
    private BookService bookService;

    public Author DtoToBo(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setSex(Author.Sex.valueOf(authorDto.getSex()));
        author.setBirthDate(authorDto.getBirthDate());
        if (authorDto.getBooks() != null) {
            author.setBooks(authorDto.getBooks().keySet().stream()
                    .map(id -> bookService.find(id)).collect(Collectors.toList()));
        }
        author.setRewards(authorDto.getRewards());
        return author;
    }

    public AuthorDto BoToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setSex(author.getSex().getName());
        authorDto.setBirthDate(author.getBirthDate());
        if (author.getBooks() != null) {
            Map<Integer, String> books = new HashMap<>();
            for (Book book : author.getBooks()) {
                books.put(book.getId(), book.getTitle());
            }
            authorDto.setBooks(books);
        }
        authorDto.setRewards(author.getRewards());
        return authorDto;
    }
}