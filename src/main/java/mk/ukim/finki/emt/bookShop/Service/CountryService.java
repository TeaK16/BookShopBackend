package mk.ukim.finki.emt.bookShop.Service;

import mk.ukim.finki.emt.bookShop.Model.Country;
import mk.ukim.finki.emt.bookShop.Model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Optional<Country> save(CountryDto countryDto);

    void deleteById(Long id);
}
