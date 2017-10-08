package com.titarenko.bookshelf.model;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Reward extends BaseObject {

    @NotNull
    private String title;
    @Min(1900)
    private Integer year;

    public Reward() {
    }

    public Reward(String title, Integer year) {
        this.year = year;
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Reward other = (Reward) o;

        return Objects.equals(year, other.year)
                && Objects.equals(title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), year, title);
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + getId() +
                ", year=" + year +
                ", title='" + title + '\'' +
                '}';
    }
}