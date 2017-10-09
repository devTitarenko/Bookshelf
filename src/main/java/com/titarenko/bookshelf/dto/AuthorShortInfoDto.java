package com.titarenko.bookshelf.dto;

import com.titarenko.bookshelf.model.Author;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuthorShortInfoDto {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<String> bookNames;

    public AuthorShortInfoDto(Author author) {
        if (author != null) {
            this.firstName = author.getFirstName();
            this.lastName = author.getLastName();
            this.age = Years.yearsBetween(
                    new LocalDate(author.getBirthDate()), new LocalDate()).getYears();
            bookNames = new ArrayList<>(author.getBooks().size());
            author.getBooks().forEach(book -> bookNames.add(book.getTitle()));
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getBookNames() {
        return bookNames;
    }

    public void setBookNames(List<String> bookNames) {
        this.bookNames = bookNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorShortInfoDto other = (AuthorShortInfoDto) o;

        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(age, other.age)
                && Objects.equals(bookNames, other.bookNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, bookNames);
    }
}
