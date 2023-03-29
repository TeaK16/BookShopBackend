package mk.ukim.finki.emt.bookShop.Model.dto;

import lombok.Data;
import mk.ukim.finki.emt.bookShop.Model.Country;

@Data
public class AuthorDto {

    private String name;

    private String surname;

    private Long countryId;

    public AuthorDto() {
    }

    public AuthorDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }
}
