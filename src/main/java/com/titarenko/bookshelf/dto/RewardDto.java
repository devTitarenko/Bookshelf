package com.titarenko.bookshelf.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class RewardDto {

    @NotNull
    private String title;
    @Min(1900)
    private Integer year;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RewardDto other = (RewardDto) o;

        return Objects.equals(title, other.title)
                && Objects.equals(year, other.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

}
