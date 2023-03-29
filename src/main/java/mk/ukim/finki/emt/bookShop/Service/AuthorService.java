package mk.ukim.finki.emt.bookShop.Service;

import mk.ukim.finki.emt.bookShop.Model.Author;
import mk.ukim.finki.emt.bookShop.Model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);

    List<Author> listAll();

    Optional<Author> save(AuthorDto authorDto);


    void deleteById(Long id);
}
