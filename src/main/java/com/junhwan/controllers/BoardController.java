package com.junhwan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junhwan.services.BoardService;
import com.junhwan.models.Board;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public List<Board> listGetAll(){
		return boardService.getfindAll();
	}
	@GetMapping("/title")
	public List<Board> listGetTitle(){
		return boardService.getfindTitle("제목..1");
	}
	@GetMapping("/writer")
	public List<Board> listGetWriterContaining(){
		return boardService.getfindWriterContaining("9");
	}
	@GetMapping("/content")
	public List<Board> listGetContent(){
		return boardService.getfindContent("내용..99");
	}
	
	@PatchMapping("/patch")
	public Board patchBoard() {
		return boardService.patchBoard(1L);
	}
}
