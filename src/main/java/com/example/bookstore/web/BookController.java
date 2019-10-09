package com.example.bookstore.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository myRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/")
	public String main() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String showbooklist(Model model) {
		model.addAttribute("books", myRepository.findAll());
		return "books";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<Book> bookListRest() {
		return myRepository.findAll();
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return myRepository.findById(bookId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addnewbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savebook(Book book) {
		myRepository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String addStudent(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", myRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deletebook(@PathVariable("id") Long bookId, Model model) {
		myRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
}