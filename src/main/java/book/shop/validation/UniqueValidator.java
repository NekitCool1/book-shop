package book.shop.validation;

import book.shop.repository.book.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueValidator implements ConstraintValidator<Unique, String> {
    private final BookRepository bookRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !bookRepository.existsByIsbn(value);
    }
}
