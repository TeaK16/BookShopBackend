package mk.ukim.finki.emt.bookShop.Service.Impl;

import mk.ukim.finki.emt.bookShop.Model.Country;
import mk.ukim.finki.emt.bookShop.Model.dto.CountryDto;
import mk.ukim.finki.emt.bookShop.Repository.CountryRepository;
import mk.ukim.finki.emt.bookShop.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(), countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
