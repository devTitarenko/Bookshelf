package com.titarenko.bookshelf.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class BookDto {
    @NotNull
    private String title;
    private String isbn;
    private String genre;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto other = (BookDto) o;

        return Objects.equals(title, other.title)
                && Objects.equals(isbn, other.isbn)
                && Objects.equals(genre, other.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, genre);
    }
}
