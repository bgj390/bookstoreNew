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
	
}
