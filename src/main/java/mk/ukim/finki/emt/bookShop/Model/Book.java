package mk.ukim.finki.emt.bookShop.Model;

import lombok.Data;
import mk.ukim.finki.emt.bookShop.Model.enumeration.Category;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     @Enumerated(EnumType.STRING)
     private Category category;
     @ManyToOne
     private Author author;
     private Integer availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book(Long id, String name, Category category, Author author, Integer availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
