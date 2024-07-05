package book.shop.repository;

import book.shop.model.Book;
import exception.DataProcessingException;
import java.util.List;

public interface BookRepository {
    Book save(Book book) throws DataProcessingException;

    List<Book> findAll();
}
