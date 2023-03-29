package mk.ukim.finki.emt.bookShop.Service.Impl;

import mk.ukim.finki.emt.bookShop.Model.Author;
import mk.ukim.finki.emt.bookShop.Model.Book;
import mk.ukim.finki.emt.bookShop.Model.dto.BookDto;
import mk.ukim.finki.emt.bookShop.Model.enumeration.Category;
import mk.ukim.finki.emt.bookShop.Model.exceptions.*;
import mk.ukim.finki.emt.bookShop.Repository.AuthorRepository;
import mk.ukim.finki.emt.bookShop.Repository.BookRepository;
import mk.ukim.finki.emt.bookShop.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        String name = bookDto.getName();
        if(name.isEmpty()) {
            return Optional.empty();
        }
        Category category = bookDto.getCategory();
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(InvalidAuthorIdException::new);
        Integer availableCopies = bookDto.getAvailableCopies();
        return Optional.of(bookRepository.save(new Book(name,category,author,availableCopies)));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        book.setName(book.getName());
        book.setCategory(bookDto.getCategory());
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() ->new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> reserveBooks(Long id, Integer number) {
      Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
      Integer availableCopies = book.getAvailableCopies();
      if( availableCopies < number ) {
          throw new ThereIsNoAvilableCopies();
      }
      book.setAvailableCopies(availableCopies-number);
      return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> returnBooks(Long id, Integer number) {
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        Integer availableCopies = book.getAvailableCopies();
        if(number < 0) {
            throw new CanNotReturnBook();
        }
        book.setAvailableCopies(availableCopies+number);
        return Optional.of(bookRepository.save(book));
    }
}
