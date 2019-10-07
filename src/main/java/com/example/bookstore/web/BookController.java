package com.example.bookstore.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String showbooklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return(List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/book/{id}",method=RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
		return repository.findById(bookId);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categoryList", categoryRepository.findAll());
		return "addnewbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savebook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String addStudent(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletebook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
}