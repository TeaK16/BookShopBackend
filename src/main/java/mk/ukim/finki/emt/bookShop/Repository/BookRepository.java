package mk.ukim.finki.emt.bookShop.Repository;

import mk.ukim.finki.emt.bookShop.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
