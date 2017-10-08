package com.titarenko.bookshelf.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Book extends BaseObject {

    private String title;
    private String isbn;
    @Enumerated(EnumType.STRING)
    private Genre genre;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book other = (Book) o;

        return Objects.equals(title, other.title)
                && Objects.equals(isbn, other.isbn)
                && Objects.equals(genre, other.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), title, isbn, genre);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre=" + genre.name +
                '}';
    }
}