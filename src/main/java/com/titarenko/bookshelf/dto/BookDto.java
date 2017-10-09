package com.titarenko.bookshelf.dto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class BookDto {
    @NotNull
    private String title;
    private String isbn;
    @NotNull
    private String genre;
    private List<Integer> authorIds;

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

    public List<Integer> getAuthors() {
        return authorIds;
    }

    public void setAuthors(List<Integer> authors) {
        this.authorIds = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto other = (BookDto) o;

        return Objects.equals(title, other.title)
                && Objects.equals(isbn, other.isbn)
                && Objects.equals(genre, other.genre)
                && Objects.equals(authorIds, other.authorIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isbn, genre, authorIds);
    }
}
