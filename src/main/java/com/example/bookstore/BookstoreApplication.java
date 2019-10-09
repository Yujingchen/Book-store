package com.example.bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(BookRepository repository,CategoryRepository crepository){
		return(args) ->{
			log.info("save a couple of books");
			crepository.save(new Category(1,"Fiction"));
			crepository.save(new Category(2,"Business"));
			crepository.save(new Category(3,"History"));
			
			repository.save(new Book("History of finland", "Johnson", 1994, 1008325346,23.0,crepository.findByName("History")));
			repository.save(new Book("There there", "Maria", 2017, 105439896,48.0,crepository.findByName("Fiction")));
			log.info("fetch all Books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
	};
}
	
}
 