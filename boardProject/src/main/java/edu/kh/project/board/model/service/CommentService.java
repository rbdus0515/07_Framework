package edu.kh.project.board.model.service;

import java.util.List;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.member.model.dto.Member;

public interface CommentService {

	/** 댓글 조회
	 * @param boardNo
	 * @return
	 */
	List<Comment> selectComment(int boardNo);

	/** 댓글 등록
	 * @param comment
	 * @return result
	 */
	int insertComment(Comment comment);

	/** 댓글 삭제
	 * @param commentNo
	 * @return result
	 */
	int deleteComment(int commentNo);

	/** 댓글 수정
	 * @param comment
	 * @return result
	 */
	int updateComment(Comment comment);

}
