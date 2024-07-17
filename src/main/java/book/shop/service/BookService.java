package book.shop.service;

import book.shop.dto.BookDto;
import book.shop.dto.BookSearchParameters;
import book.shop.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);

    List<BookDto> findAll();

    BookDto updateBookById(Long id);

    void deleteBookById(Long id);

    List<BookDto> search(BookSearchParameters bookSearchParameters);
}
