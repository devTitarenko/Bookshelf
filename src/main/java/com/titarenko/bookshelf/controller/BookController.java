package com.titarenko.bookshelf.controller;

import com.titarenko.bookshelf.dto.*;
import com.titarenko.bookshelf.model.Author;
import com.titarenko.bookshelf.model.Book;
import com.titarenko.bookshelf.service.AuthorService;
import com.titarenko.bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookService service;
    @Autowired
    private BookDtoMapper mapper;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewBook(@RequestParam String title) {
        Book book = new Book();
        book.setTitle(title);
        service.save(book);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<BookDto> getAllBooks() {
        List<BookDto> bookDtoList = new ArrayList<>();
        service.findAll().forEach(book -> bookDtoList.add(mapper.BoToDto(book)));
        return bookDtoList;
    }

    @GetMapping(path = "/info/{id}")
    public @ResponseBody BookDto getBookInfo(@PathVariable("id") Integer id) {
        return mapper.BoToDto(service.find(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteBook(@PathVariable("id") Integer id) {
        service.delete(id);
        return "Deleted";
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAuthor(@RequestBody BookDto bookDto) {
        service.save(mapper.DtoToBo(bookDto));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAuthor(@RequestBody BookDto bookDto) {
        service.save(mapper.DtoToBo(bookDto));
    }
}