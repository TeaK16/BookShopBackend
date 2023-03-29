package mk.ukim.finki.emt.bookShop.Repository;

import mk.ukim.finki.emt.bookShop.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
