package mk.ukim.finki.emt.bookShop.Web.rest;

import mk.ukim.finki.emt.bookShop.Model.Country;
import mk.ukim.finki.emt.bookShop.Model.dto.CountryDto;
import mk.ukim.finki.emt.bookShop.Service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/country")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll(){
        return this.countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestParam String name,
                                        @RequestParam String continent){
        CountryDto countryDto = new CountryDto(name,continent);
        return this.countryService.save(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }


}
