package com.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositry.BookRepository;


@Service
public class BookManager {
	
	@Autowired
	BookRepository BR;
	
	public String saveBook(Book B)throws Exception
	{
//		BR.save(B);	 //INSERT OPERATION
		BR.save(B);
		return "New book has been added";
	}
	
	
	
	public List<Book> getBooks()
	  {
	    List<Book> booklist = BR.findAll();
	    return booklist;
	  }
}
