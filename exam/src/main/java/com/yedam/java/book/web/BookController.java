package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("bookList", bookService.getBookList());
		return "book/bookList";
	}
	
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookNo", bookService.test());
		return "book/bookInsert";
	}
	
	@PostMapping("bookInsert")
	public String bookInsert(BookVO bookVO, Model model) {
		bookService.insert(bookVO);
		return "redirect:bookList";
	}
	
}
