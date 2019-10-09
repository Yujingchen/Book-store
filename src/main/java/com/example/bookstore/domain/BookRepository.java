package com.example.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	 List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
	 List<Book> findByIsbn(int isbn);
	 List<Book> findByAuthorOrderByYear(String author);
	 List<Book> findById(int id);
	 List<Book> deleteById(int id);
}