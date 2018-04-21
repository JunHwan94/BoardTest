package com.junhwan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junhwan.models.Board;
import com.junhwan.repositories.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public List<Board> getfindAll(){
		return boardRepository.findAll();
	}
	public List<Board> getfindTitle(String title) {
		return boardRepository.findByTitle(title);
	}
	
	public List<Board> getfindContent(String content){
		return boardRepository.findByContent(content);
	}
	
	public List<Board> getfindWriterContaining(String writer){
		return boardRepository.findByWriterContaining(writer);
	}
	
	public Board patchBoard(Long id) {
		Optional<Board> board = boardRepository.findById(id);
		if(board.isPresent()) {
			Board patchBoard = board.get();
			patchBoard.setTitle("(patch)" + board.get().getTitle());
			
			return boardRepository.save(patchBoard);
		}
		return null;
	}
}