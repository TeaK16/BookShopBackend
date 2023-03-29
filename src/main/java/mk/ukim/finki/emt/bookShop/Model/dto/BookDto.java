package mk.ukim.finki.emt.bookShop.Model.dto;

import lombok.Data;
import mk.ukim.finki.emt.bookShop.Model.Author;
import mk.ukim.finki.emt.bookShop.Model.enumeration.Category;


import java.util.List;

@Data
public class BookDto {

    private String name;

    private Category category;

    private Long authorId;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
