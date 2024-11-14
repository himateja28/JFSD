package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;
import com.model.BookManager;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookManager BM;
	
	@PostMapping("/save")
	public String save(@RequestBody Book B)
	{
		try
		{
			return BM.saveBook(B);
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}
	@GetMapping("/read")
	  public String read()
	  {
	    return BM.getBooks().toString();
	  }
}
