package com.example.bookstoreNew;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstoreNew.model.Book;
import com.example.bookstoreNew.model.BookRepository;
import com.example.bookstoreNew.model.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Happoa lapsille");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Flea");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Happoa lapsille", "Flea", 2019, "978-952-01-1967-6", 20.90, new Category("Autobiography"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void shouldDeleteAll() {
		repository.deleteAll();
		Iterable<Book> books = repository.findAll();
		
		assertThat(books).hasSize(0);

	}
}
