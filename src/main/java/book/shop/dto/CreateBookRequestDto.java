package book.shop.dto;

import book.shop.validation.Author;
import book.shop.validation.Unique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @Size(min = 50)
    private String description;
    private String coverImage;
    @NotBlank
    @Unique
    private String isbn;
}
