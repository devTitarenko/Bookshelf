package com.titarenko.bookshelf.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Author extends BaseObject {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Collection<Book> books;

    @Past
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FK_AUTHOR_ID", referencedColumnName = "ID")
    private List<Reward> rewards;

    public enum Sex {
        MALE("Male"),
        FEMALE("Female");

        private final String name;

        Sex(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static final Format dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.UK);

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Author other = (Author) o;

        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(sex, other.sex)
                && Objects.equals(books, other.books)
                && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(rewards, other.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), firstName, lastName, sex, books, birthDate, rewards);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex.name +
                ", birthDate=" + dateFormat.format(birthDate) +
                ", rewards=" + rewards +
                '}';
    }
}
