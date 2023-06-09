package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd") // 소문자 m으로 했을 시에 분으로 받아들여질 수도 있다
	private Date regdate; // yyyy/MM/dd (기본방식) yyyy-MM-dd
	@DateTimeFormat(pattern="yyyy-MM-dd") // 입력받을때 parttern의 방식으로 받는다
	private Date updatedate;
	private String image;
}
