package com.titarenko.bookshelf.dto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BookDto {
    @NotNull
    private String title;
    private String isbn;
    @NotNull
    private String genre;
    private Map<Integer, String> authors;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Map<Integer, String> getAuthors() {
        return authors;
    }

    public void setAuthors(Map<Integer, String> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto other = (BookDto) o;

        return Objects.equals(title, other.title)
                && Objects.equals(isbn, other.isbn)
                && Objects.equals(genre, other.genre)
                && Objects.equals(authors, other.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, genre, authors);
    }
}
