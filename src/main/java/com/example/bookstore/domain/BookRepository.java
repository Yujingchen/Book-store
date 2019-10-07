package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository<Book, Long> {
	 List<Book> findByBookName(String name);
	 List<Book> findByAuthorName(String author);
	 List<Book> findByISBN(int isbn);
	 List<Book> findByAuthorOderByYear(String author);
	 List<Book> findById(int id);
	 List<Book> deleteById(int id);
}