package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {

	/** 게시글 종류 목록 조회
	 * @return
	 */
	List<Map<String, Object>> selectBoardList();

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);

	/** 게시글 상세 조회 서비스
	 * @param map
	 * @return board
	 */
	Board selectBoard(Map<String, Object> map);
	
}
