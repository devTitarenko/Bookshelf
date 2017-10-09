package com.titarenko.bookshelf.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.titarenko.bookshelf.model.Reward;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AuthorDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String sex;
    private List<Integer> bookIds;
    @Past
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING, timezone="CET")
    private Date birthDate;
    private List<Reward> rewards;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Integer> getBooks() {
        return bookIds;
    }

    public void setBooks(List<Integer> bookIds) {
        this.bookIds = bookIds;
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

        AuthorDto other = (AuthorDto) o;

        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(sex, other.sex)
                && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(bookIds, other.bookIds)
                && Objects.equals(rewards, other.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, sex, birthDate, bookIds, rewards);
    }
}
