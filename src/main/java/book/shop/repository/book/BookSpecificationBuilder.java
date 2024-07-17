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
    private SpecificationProviderManager<Book> specificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchParameters.titles() != null && searchParameters.titles().length > 0) {
            spec.and(specificationProviderManager.getSpecificationProvider("title")
                    .getSpecification(searchParameters.titles()));
        }
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            spec.and(specificationProviderManager.getSpecificationProvider("author")
                    .getSpecification(searchParameters.authors()));
        }
        return spec;
    }
}
