package book.shop.dto;

import book.shop.validation.Author;
import book.shop.validation.Unique;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotNull
    private String title;
    @NotNull
    @Author
    private String author;
    @NotNull
    @Min(0)
    private BigDecimal price;
    private String description;
    private String coverImage;
    @NotNull
    @Unique
    private String isbn;
}
