package com.example.bookstore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
	 List<Book> findByBookName(String name);
	 List<Book> findByAuthorName(String author);
	 List<Book> findByISBN(int isbn);
	 List<Book> findByAuthorOderByYear(String author);
}
