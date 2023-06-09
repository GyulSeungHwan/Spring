package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> getBookList();
	public List<BookVO> getBookByRent(int[] rent);
	int insert(BookVO vo);
	String test();
}
