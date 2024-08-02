package book.shop.service;

import book.shop.dto.BookDto;
import book.shop.dto.BookSearchParameters;
import book.shop.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);

    List<BookDto> findAll(Pageable pageable);

    BookDto updateBookById(Long id, CreateBookRequestDto bookRequestDto);

    void deleteBookById(Long id);

    List<BookDto> search(BookSearchParameters bookSearchParameters);
}
