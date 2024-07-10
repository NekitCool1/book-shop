package book.shop;

import book.shop.model.Book;
import book.shop.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Book harryPotter = new Book();
            harryPotter.setAuthor("J.Rolling");
            harryPotter.setDescription("gbhyurejklwhgiuorew");
            harryPotter.setPrice(BigDecimal.valueOf(1000));
            harryPotter.setTitle("Harry Potter");
            harryPotter.setCoverImage("nfjikwalerhfjwelikr");
            harryPotter.setIsbn("nfui3ehueri");
            System.out.println(bookService.save(harryPotter));
            System.out.println(bookService.findAll());
        };
    }

}
