package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;

public interface BookMapper {
	public List<BookVO> getBookList(); // 도서목록조회
	public List<BookVO> getBookByRent(int[] rent); // 도서대여현황조회
	int insert(BookVO vo); // 도서정보등록
	String test();
}
