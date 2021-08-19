package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.node.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		repository.save(book);
		return "Book Added";
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return (List<Book>) repository.findAll();
	}
	
	@GetMapping("/getBook/{name}")
	public Book getBook(@PathVariable String name){
		return repository.findByName(name);
	}
	
	@GetMapping("/getBook/{id}")
	public String deleteBook(@PathVariable int id){
		repository.deleteById(id);
		return "Book deleted with id:" + id;
		
	}
}
