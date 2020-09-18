package com.example.bookstoreNew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstoreNew.model.Book;
import com.example.bookstoreNew.model.BookRepository;
import com.example.bookstoreNew.model.Category;
import com.example.bookstoreNew.model.CategoryRepository;

@SpringBootApplication
public class BookstoreNewApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreNewApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreNewApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a few books");
		
			crepository.save(new Category("Autobiography"));
			crepository.save(new Category("Science Fiction"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Satire"));
			
			brepository.save(new Book("Happoa lapsille", "Flea", 2019, "978-952-01-1967-6", 20.90, crepository.findByName("Autobiography").get(0)));
			brepository.save(new Book("Tyttö bändissä", "Kim Gordon", 2015, "978-952-01-1015-4", 9.95, crepository.findByName("Autobiography").get(0)));
			brepository.save(new Book("science fiction-valikoima", "Isaac Asimov", 1981, "996611-1-01", 12.50, crepository.findByName("Science Fiction").get(0)));
				
				log.info("fetch all books");
				for (Book book : brepository.findAll()) {
					log.info(book.toString());
				}
				
		};
	}
}
