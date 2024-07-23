package book.shop.repository.book;

import book.shop.model.Book;
import book.shop.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    private static final String key = "title";

    @Override
    public String getKey() {
        return key;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get("title")
                .in(Arrays.stream(params)
                        .toArray());
    }
}
