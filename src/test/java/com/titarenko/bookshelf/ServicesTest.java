package com.titarenko.bookshelf;

import com.titarenko.bookshelf.model.Author;
import com.titarenko.bookshelf.model.Book;
import com.titarenko.bookshelf.repository.BookRepository;
import com.titarenko.bookshelf.service.AuthorService;
import com.titarenko.bookshelf.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTest {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    private Author author;
    private Book book;

    @Before
    public void before(){
        author = new Author();
        author.setFirstName("George");
        author.setLastName("Martin");
        author.setSex(Author.Sex.MALE);
        author.setBooks(new ArrayList<Book>() {{
            add(book);
        }});
        book = new Book("A Song of Ice and Fire", "0-553-10354-7", Book.Genre.FANTASY);
        book.setAuthors(new ArrayList<Author>() {{
            add(author);
        }});

    }

    @Test
    @Transactional
    public void testAuthorCrud() throws Exception {
        authorService.save(author);
        Author savedAuthor = authorService.find(author.getId());
        assertNotNull(savedAuthor);
        assertEquals(author, savedAuthor);
        authorService.delete(author.getId());
        assertNull(authorService.find(author.getId()));
    }

    @Test
    @Transactional
    public void testBookCrud() throws Exception {
        bookService.save(book);
        Book savedBook = bookService.find(book.getId());
        assertNotNull(savedBook);
        assertEquals(book, savedBook);
        bookService.delete(book.getId());
        assertNull(bookService.find(book.getId()));
    }
}
