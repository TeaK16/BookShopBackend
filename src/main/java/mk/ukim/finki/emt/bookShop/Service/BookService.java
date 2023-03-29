package mk.ukim.finki.emt.bookShop.Service;

import mk.ukim.finki.emt.bookShop.Model.Author;
import mk.ukim.finki.emt.bookShop.Model.Book;
import mk.ukim.finki.emt.bookShop.Model.dto.BookDto;
import mk.ukim.finki.emt.bookShop.Model.enumeration.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    List<Book> findAll();

    Optional<Book> save(BookDto bookDto);

    Optional<Book> update(Long id, BookDto bookDto);
    void deleteById(Long id);

    Optional<Book> reserveBooks(Long id, Integer number);

    Optional<Book> returnBooks(Long id, Integer number);

}
