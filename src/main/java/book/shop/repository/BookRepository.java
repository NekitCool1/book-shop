package book.shop.repository;

import book.shop.model.Book;
import exception.DataProcessingException;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book) throws DataProcessingException;

    List<Book> findAll();

    Optional<Book> getBookById(Long id);
}
