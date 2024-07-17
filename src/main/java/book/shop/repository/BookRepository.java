package book.shop.repository;

import book.shop.dto.BookDto;
import book.shop.dto.CreateBookRequestDto;
import book.shop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
