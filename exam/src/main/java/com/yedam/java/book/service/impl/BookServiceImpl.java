package com.yedam.java.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper mapper;

	@Override
	public List<BookVO> getBookList() {
		return mapper.getBookList();
	}

	@Override
	public List<BookVO> getBookByRent(int[] rent) {
		return null;
	}

	@Override
	public int insert(BookVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public String test() {
		return mapper.test();
	}
	
}
