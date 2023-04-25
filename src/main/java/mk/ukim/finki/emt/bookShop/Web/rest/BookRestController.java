package mk.ukim.finki.emt.bookShop.Web.rest;

import mk.ukim.finki.emt.bookShop.Model.Author;
import mk.ukim.finki.emt.bookShop.Model.Book;
import mk.ukim.finki.emt.bookShop.Model.dto.BookDto;
import mk.ukim.finki.emt.bookShop.Model.enumeration.Category;
import mk.ukim.finki.emt.bookShop.Service.BookService;
import org.springframework.expression.spel.ast.LongLiteral;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listAllBooks() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> sava(@RequestParam String name,
                                     @RequestParam Category category,
                                     @RequestParam Long authorId,
                                     @RequestParam Integer availableCopies) {
        BookDto bookDto = new BookDto(name, category, authorId, availableCopies);
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id,
                                       @RequestParam String name,
                                       @RequestParam Category category,
                                       @RequestParam Long authorId,
                                       @RequestParam Integer availableCopies) {

        BookDto bookDto = new BookDto(name, category, authorId, availableCopies);
        return this.bookService.update(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/reserveBook/{id}")
    public ResponseEntity<Book> reserveBook(@PathVariable Long id) {
        Integer number = 1;
        return this.bookService.reserveBooks(id, number)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/returnBook/{id}")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        Integer number = 1;
        return this.bookService.returnBooks(id,number)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}

