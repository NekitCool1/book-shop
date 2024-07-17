package book.shop.mapper;

import book.shop.config.MapperConfig;
import book.shop.dto.BookDto;
import book.shop.dto.CreateBookRequestDto;
import book.shop.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);

    void updateBookFromDto(BookDto bookDto, @MappingTarget Book book);
}
