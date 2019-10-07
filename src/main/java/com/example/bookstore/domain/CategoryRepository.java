package com.example.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long>{
	Category findByname(String name);
}
