package book.shop.dto;

import java.math.BigDecimal;

public record CreateBookRequestDto(String title,
        String author,
        BigDecimal price,
        String description,
        String coverImage) {
}
