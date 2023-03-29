package mk.ukim.finki.emt.bookShop.Service.Impl;

import mk.ukim.finki.emt.bookShop.Model.Author;
import mk.ukim.finki.emt.bookShop.Model.Country;
import mk.ukim.finki.emt.bookShop.Model.dto.AuthorDto;
import mk.ukim.finki.emt.bookShop.Model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt.bookShop.Repository.AuthorRepository;
import mk.ukim.finki.emt.bookShop.Repository.CountryRepository;
import mk.ukim.finki.emt.bookShop.Service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country =  this.countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException(authorDto.getCountryId()));
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
       if(authorDto.getName().isEmpty() || authorDto.getSurname().isEmpty())
           return Optional.empty();
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
