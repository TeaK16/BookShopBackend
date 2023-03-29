package mk.ukim.finki.emt.bookShop.Model.exceptions;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id %d was not found",id));
    }
}
