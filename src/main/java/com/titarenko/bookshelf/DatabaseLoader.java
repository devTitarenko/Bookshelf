package com.titarenko.bookshelf;

import com.titarenko.bookshelf.model.Author;
import com.titarenko.bookshelf.model.Book;
import com.titarenko.bookshelf.model.Reward;
import com.titarenko.bookshelf.repository.AuthorRepository;
import com.titarenko.bookshelf.repository.BookRepository;
import com.titarenko.bookshelf.repository.RewardRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final RewardRepository rewardRepository;

    private Author rBloch;
    private Author sKing;
    private Author jRowling;
    private Author jBrodsky;
    private Author tMorrison;


    @Autowired
    public DatabaseLoader(AuthorRepository authorRepository, BookRepository bookRepository, RewardRepository rewardRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.rewardRepository = rewardRepository;
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        if (!authorRepository.findAll().iterator().hasNext()) {
            dataGenerator();
            this.authorRepository.save(rBloch);
            this.authorRepository.save(sKing);
            this.authorRepository.save(jRowling);
            this.authorRepository.save(jBrodsky);
            this.authorRepository.save(tMorrison);
        }
    }

    private void dataGenerator() {
        Reward award0 = new Reward("Bram Stoker Award", 1987);
        Reward award1 = new Reward("Bram Stoker Award", 2013);
        Reward award2 = new Reward("National Book Award", 2003);
        Reward award3 = new Reward("Horror Guild", 2001);
        Reward award4 = new Reward("World Fantasy Award", 1980);
        Reward award5 = new Reward("Nobel Prize in Literature", 1987);
        Reward award6 = new Reward("World Fantasy Award", 1975);
        Reward award7 = new Reward("British Book Awards", 2000);
        Reward award8 = new Reward("Nobel Prize for Literature", 1993);

        Book book0 = new Book("The Dark Tower", "978-0-937986-50-9", Book.Genre.FANTASY);
        Book book1 = new Book("Night of the Ripper", "978-0-385-19422-8", Book.Genre.CRIME);
        Book book2 = new Book("The Shining", "978-0-385-12167-5", Book.Genre.HORROR);
        Book book3 = new Book("Pet Sematary", "978-0-385-18244-7", Book.Genre.HORROR);
        Book book4 = new Book("Harry Potter", "0-7475-3269-9", Book.Genre.FANTASY);
        Book book5 = new Book("Collected Poems in English", null, Book.Genre.POETRY);
        Book book6 = new Book("Rita Hayworth and Shawshank Redemption", null, Book.Genre.CRIME);

        rBloch = new Author();
        rBloch.setFirstName("Robert");
        rBloch.setLastName("Bloch");
        rBloch.setSex(Author.Sex.MALE);
        rBloch.setBirthDate((new LocalDate(1917, 4, 5)).toDate());
        rBloch.setBooks(new ArrayList<Book>() {{
            add(book1);
            add(book0);
            add(book6);
        }});
        rBloch.setRewards(new ArrayList<Reward>() {{
            add(award6);
        }});

        sKing = new Author();
        sKing.setFirstName("Stephen");
        sKing.setLastName("King");
        sKing.setSex(Author.Sex.MALE);
        sKing.setBirthDate((new LocalDate(1947, 9, 21)).toDate());
        sKing.setBooks(new ArrayList<Book>() {{
            add(book0);
            add(book2);
            add(book3);
            add(book6);
        }});
        sKing.setRewards(new ArrayList<Reward>() {{
            add(award0);
            add(award1);
            add(award2);
            add(award3);
            add(award4);
        }});

        jRowling = new Author();
        jRowling.setFirstName("Joanne");
        jRowling.setLastName("Rowling");
        jRowling.setSex(Author.Sex.FEMALE);
        jRowling.setBirthDate((new LocalDate(1965, 7, 31)).toDate());
        jRowling.setBooks(new ArrayList<Book>() {{
            add(book0);
            add(book4);
        }});
        jRowling.setRewards(new ArrayList<Reward>() {{
            add(award7);
        }});

        jBrodsky = new Author();
        jBrodsky.setFirstName("Joseph");
        jBrodsky.setLastName("Brodsky");
        jBrodsky.setSex(Author.Sex.MALE);
        jBrodsky.setBirthDate((new LocalDate(1940, 5, 24)).toDate());
        jBrodsky.setBooks(new ArrayList<Book>() {{
            add(book4);
            add(book5);
        }});

        tMorrison = new Author();
        tMorrison.setFirstName("Toni");
        tMorrison.setLastName("Morrison");
        tMorrison.setSex(Author.Sex.FEMALE);
        tMorrison.setBirthDate((new LocalDate(1931, 2, 18)).toDate());
        tMorrison.setRewards(new ArrayList<Reward>() {{
            add(award8);
        }});
    }
}