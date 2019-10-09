package com.example.bookstore;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;



public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	private CategoryRepository crepository;
	@Test
	public void findBynameShouldReturnBook() {
		List<Book> books = repository.findByTitle("History of Finland");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("History of Finland");
	}
    @Test
    public void createNewStudent() {
    	Book book = new Book("History of China", "yujing", 2018, 1234890,34.0, crepository.findByName("History"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
} 
	
}


