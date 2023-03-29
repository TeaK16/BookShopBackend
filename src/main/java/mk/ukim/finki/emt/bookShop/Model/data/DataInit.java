package mk.ukim.finki.emt.bookShop.Model.data;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.bookShop.Model.Author;
import mk.ukim.finki.emt.bookShop.Model.Country;
import mk.ukim.finki.emt.bookShop.Model.dto.AuthorDto;
import mk.ukim.finki.emt.bookShop.Model.dto.BookDto;
import mk.ukim.finki.emt.bookShop.Model.dto.CountryDto;
import mk.ukim.finki.emt.bookShop.Model.enumeration.Category;
import mk.ukim.finki.emt.bookShop.Service.AuthorService;
import mk.ukim.finki.emt.bookShop.Service.BookService;
import mk.ukim.finki.emt.bookShop.Service.CountryService;
import org.springframework.stereotype.Component;

@Component
public class DataInit {

    private final CountryService countryService ;

    private final AuthorService authorService;

    private final BookService bookService;

    public DataInit(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void init() {
        Country country = countryService.save(new CountryDto("Germany","Europe")).get();
        Author author = authorService.save(new AuthorDto("Tomas","Man",country.getId())).get();
        bookService.save(new BookDto("The magic mountain", Category.DRAMA, author.getId(),400));
        country = countryService.save(new CountryDto("Turkey","Europe-Asia")).get();
        author = authorService.save(new AuthorDto("Orhan","Pamuk",country.getId())).get();
        bookService.save(new BookDto("The Museum of Innocence",Category.HISTORY, author.getId(),200));

    }


}
