package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
//	@GetMapping("boardList")
//	public String getBoardAllList(Model model) {
//		model.addAttribute("boardList", boardService.getBoardList());
//		return "board/boardList";
//	}
	
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		// list에 담아준 이유는 getBoardList()가 어떤 타입으로 받아들여지는지 몰라서 어떤 타입인지 알려고 적었다
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findBoard = boardService.getBoardInfo(boardVO);
		model.addAttribute("board", findBoard);
		return "board/boardInfo";
	}
	
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		// 페이지를 열 때 데이터를 보내야 한다면 데이터를 보내줘야 한다
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
//	@PostMapping("boardInsert")
//	public String boardInsert(BoardVO boardVO, RedirectAttributes rtt) {
//		boardService.insertBoardInfo(boardVO);
//		rtt.addFlashAttribute("bno", boardVO.getBno());
//		rtt.addAttribute("msg", "test");
//		return "redirect:boardList";
//	}
	
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO boardVO, Model model) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		BoardVO findBoard = boardService.getBoardInfo(boardVO);
		model.addAttribute("board", findBoard);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
//	@PostMapping("boardUpdate")
//	@ResponseBody
//	public String boardUpdate(@RequestBody BoardVO boardVO) {
//		int result = boardService.updateBoardInfo(boardVO);
//		System.out.println(result);
//		if(result > 0) {
//			return "success";
//		} else {
//			return "false";
//		}
//	}
	
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdate(BoardVO boardVO) {
		boolean result = false;
		int boardNo = boardService.updateBoardInfo(boardVO);
		if(boardNo > -1) {
			result = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("board_no", boardNo);
		
		return map;
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
//	@GetMapping("boardDelete")
//	public String boardDelete(int bno) {
//		boardService.deleteBoardInfo(bno);
//		return "redirect:boardList";
//	}
	
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam(required = false, defaultValue = "0", name = "bno") int bno) {
		// required - 기본 값이 true, defaultValue - null을 가질 수가 없다
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}
}
