package com.example.bookstoreNew;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstoreNew.model.User;
import com.example.bookstoreNew.model.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = repository.findByUsername("user");
		
		assertThat(user.getRole()).isEqualTo("USER");
	}
}
