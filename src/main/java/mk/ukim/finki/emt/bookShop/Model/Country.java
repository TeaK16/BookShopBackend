package mk.ukim.finki.emt.bookShop.Model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;

    public Country() {
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;

    }

    public Country(Long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;

    }
}
