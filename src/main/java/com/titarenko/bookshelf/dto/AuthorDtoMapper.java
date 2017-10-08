package com.titarenko.bookshelf.dto;

import com.titarenko.bookshelf.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoMapper {

    public Author DtoToBo(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setSex(Author.Sex.valueOf(authorDto.getSex()));
        author.setBirthDate(authorDto.getBirthDate());
        author.setBooks(authorDto.getBooks());
        author.setRewards(authorDto.getRewards());
        return author;
    }

    public AuthorDto BoToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setSex(author.getSex().getName());
        authorDto.setBirthDate(author.getBirthDate());
        authorDto.setBooks(author.getBooks());
        authorDto.setRewards(author.getRewards());
        return authorDto;
    }

}
