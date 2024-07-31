package book.shop.dto;

import book.shop.validation.Author;
import book.shop.validation.Unique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    @Author
    private String author;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotBlank
    @Unique
    private String description;
    private String coverImage;
    @NotBlank
    @Unique
    private String isbn;
}
