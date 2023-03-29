package mk.ukim.finki.emt.bookShop.Repository;

import mk.ukim.finki.emt.bookShop.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
