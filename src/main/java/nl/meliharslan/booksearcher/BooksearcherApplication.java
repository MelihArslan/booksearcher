package nl.meliharslan.booksearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BooksearcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksearcherApplication.class, args);
    }

}
