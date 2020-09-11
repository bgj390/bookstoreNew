package com.example.bookstoreNew.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstoreNew.model.Book;
import com.example.bookstoreNew.model.BookRepository;

@Controller
public class BookController {
	@Autowired 
	private BookRepository repository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		return "index";
	}
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    } 
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    } 
}