package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String showbooklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String savebook(Model model) {
		model.addAttribute("book", new Book());
		return "addnewbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savebook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deletebook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:booklist";
	}

}