package com.example.bookstoreNew;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstoreNew.model.CategoryRepository;
import com.example.bookstoreNew.model.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> cats = repository.findByName("Autobiography");
		
		assertThat(cats).hasSize(1);
	}
	
	@Test
	public void createNewCategory() {
		Category cat = new Category("Cook book");
		repository.save(cat);
		assertThat(cat.getCategoryId()).isNotNull();
	}
	
	@Test
	public void shouldDeleteById() {
		Category cat1 = new Category("History");
		Category cat2 = new Category("Comic");
		repository.save(cat1);
		repository.save(cat2);
		
		repository.deleteById(cat1.getCategoryId());
		Iterable<Category> cats = repository.findAll();
		
		assertThat(cats).hasSize(5);
		assertThat(cats).doesNotContain(cat1);
	}
	
}
