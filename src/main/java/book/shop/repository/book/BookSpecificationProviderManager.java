package book.shop.repository.book;

import book.shop.model.Book;
import book.shop.repository.SpecificationProvider;
import book.shop.repository.SpecificationProviderManager;
import exception.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream()
                .filter(b -> b.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find correct specification provider for key: " + key));
    }
}
