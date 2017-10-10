package com.titarenko.bookshelf.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book extends BaseObject {

    @NotNull
    private String title;
    private String isbn;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Collection<Author> authors;

    public Book() {
    }

    public Book(String title, String isbn, Genre genre) {
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    public enum Genre {
        CRIME("Crime"),
        FANTASY("Fantasy"),
        ROMANCE("Romance"),
        SCIENCE("Science fiction"),
        WESTERN("Western"),
        HORROR("Horror"),
        POETRY("Poetry");

        private final String name;

        Genre(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book other = (Book) o;

        return Objects.equals(title, other.title)
                && Objects.equals(isbn, other.isbn)
                && Objects.equals(genre, other.genre)
                && Objects.equals(authors, other.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), title, isbn, genre, authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre=" + genre.name +
                (authors != null ? ", number of authors=" + authors.size() : "") +
                '}';
    }
}