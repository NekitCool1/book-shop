package book.shop.repository.book;

import book.shop.dto.BookSearchParameters;
import book.shop.model.Book;
import book.shop.repository.SpecificationBuilder;
import book.shop.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private static final String KEY_FOR_TITLE = "title";
    private static final String KEY_FOR_AUTHOR = "author";
    private final SpecificationProviderManager<Book> specificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchParameters.titles() != null && searchParameters.titles().length > 0) {
            spec = spec.and(specificationProviderManager.getSpecificationProvider(KEY_FOR_TITLE)
                    .getSpecification(searchParameters.titles()));
        }
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            spec = spec.and(specificationProviderManager.getSpecificationProvider(KEY_FOR_AUTHOR)
                    .getSpecification(searchParameters.authors()));
        }
        return spec;
    }
}
