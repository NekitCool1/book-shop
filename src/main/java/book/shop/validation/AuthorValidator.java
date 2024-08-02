package book.shop.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class AuthorValidator implements ConstraintValidator<Author, String> {
    private static final String PATTERN_FOR_AUTHOR = "^[A-Z][a-z]*\\s[A-Z][a-z]*$";

    @Override
    public boolean isValid(String author, ConstraintValidatorContext constraintValidatorContext) {
        return author != null && Pattern.compile(PATTERN_FOR_AUTHOR).matcher(author).matches();
    }
}
