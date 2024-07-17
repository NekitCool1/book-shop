package book.shop.service.impl;

import book.shop.dto.BookDto;
import book.shop.dto.CreateBookRequestDto;
import book.shop.mapper.BookMapper;
import book.shop.model.Book;
import book.shop.repository.BookRepository;
import book.shop.service.BookService;
import exception.EntityNotFoundException;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        book.setIsbn(String.valueOf(new Random().nextInt(1000)));
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find the book with id: " + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto updateBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't found a book with id: " + id));
        bookMapper.updateBookFromDto(bookMapper.toDto(book), book);
        return bookMapper.toDto(bookRepository.save(book));

    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
