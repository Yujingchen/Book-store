package com.example.bookstore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	private List<Book> books;
	
	public Category(long id, String name,List<Book> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}	
}
