package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dao.CommentDAO;
import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO dao;
	
	// 댓글 목록 조회 서비스
	@Override
	public List<Comment> selectComment(int boardNo) {
		
		return dao.selectComment(boardNo);
	}

	// 댓글 등록 서비스
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertComment(Comment comment) {
		
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		
		return dao.insertComment(comment);
	}

	// 댓글 삭제
	@Override
	public int deleteComment(int commentNo) {
		return dao.deleteComment(commentNo);
	}

	// 댓글 수정
	@Override
	public int updateComment(Comment comment) {
		return dao.updateComment(comment);
	}

}
