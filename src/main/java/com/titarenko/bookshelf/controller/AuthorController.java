package com.titarenko.bookshelf.controller;

import com.titarenko.bookshelf.dto.AuthorDto;
import com.titarenko.bookshelf.dto.AuthorDtoMapper;
import com.titarenko.bookshelf.dto.AuthorShortInfoDto;
import com.titarenko.bookshelf.model.*;
import com.titarenko.bookshelf.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {

    @Autowired
    private AuthorService service;
    @Autowired
    private AuthorDtoMapper mapper;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewAuthor(@RequestParam String firstName, @RequestParam String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        service.save(author);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<AuthorDto> getAllAuthors() {
        List<AuthorDto> list = new ArrayList<>();
        service.findAll().forEach(author -> list.add(mapper.BoToDto(author)));
        return list;
    }

    @GetMapping(path = "/info/{id}")
    public @ResponseBody AuthorDto getAuthorInfo(@PathVariable("id") Integer id) {
        return mapper.BoToDto(service.find(id));
    }

    @GetMapping(path = "/info/short/{id}")
    public @ResponseBody AuthorShortInfoDto getAuthorShortInfo(@PathVariable("id") Integer id) {
        return new AuthorShortInfoDto(service.find(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteAuthor(@PathVariable("id") Integer id) {
        service.delete(id);
        return "Deleted";
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateAuthor(@RequestBody @Valid AuthorDto authorDto) {
        Author author = mapper.DtoToBo(authorDto);
        service.save(author);
        return "Author's id is: " + author.getId();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createAuthor(@RequestBody @Valid AuthorDto authorDto) {
        Author author = mapper.DtoToBo(authorDto);
        service.save(author);
        return "Author's id is: " + author.getId();
    }
}