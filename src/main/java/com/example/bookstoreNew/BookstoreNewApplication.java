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
import com.example.bookstoreNew.model.User;
import com.example.bookstoreNew.model.CategoryRepository;
import com.example.bookstoreNew.model.UserRepository;

@SpringBootApplication
public class BookstoreNewApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreNewApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreNewApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a few books");
			
			// Create categories
			crepository.save(new Category("Autobiography"));
			crepository.save(new Category("Science Fiction"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Satire"));
			
			// Create books
			brepository.save(new Book("Happoa lapsille", "Flea", 2019, "978-952-01-1967-6", 20.90, crepository.findByName("Autobiography").get(0)));
			brepository.save(new Book("Tyttö bändissä", "Kim Gordon", 2015, "978-952-01-1015-4", 9.95, crepository.findByName("Autobiography").get(0)));
			brepository.save(new Book("science fiction-valikoima", "Isaac Asimov", 1981, "996611-1-01", 12.50, crepository.findByName("Science Fiction").get(0)));
				
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.deleteAll();
			urepository.save(user1);
			urepository.save(user2);
			
				log.info("fetch all books");
				for (Book book : brepository.findAll()) {
					log.info(book.toString());
				}
				
		};
	}
}
