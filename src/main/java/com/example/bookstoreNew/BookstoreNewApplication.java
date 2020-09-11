package com.example.bookstoreNew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstoreNew.model.Book;
import com.example.bookstoreNew.model.BookRepository;

@SpringBootApplication
public class BookstoreNewApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreNewApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreNewApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a few books");
				repository.save(new Book("Happoa lapsille", "Flea", 2019, "978-952-01-1967-6", 20.90));
				repository.save(new Book("Tyttö bändissä", "Kim Gordon", 2015, "978-952-01-1015-4", 9.95));
				
				log.info("fetch all books");
				for (Book book : repository.findAll()) {
					log.info(book.toString());
				}
				
		};
	}
}
