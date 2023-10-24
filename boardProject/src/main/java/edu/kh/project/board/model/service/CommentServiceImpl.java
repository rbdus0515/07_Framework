package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.CommentDAO;
import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO dao;
	
	// 댓글 조회 서비스
	@Override
	public List<Comment> selectComment(int boardNo) {
		
		return dao.selectComment(boardNo);
	}

	// 댓글 등록 서비스
	@Override
	public int insertComment(Comment comment) {
		
		comment.setCommentContent(Util.XSSHandling(comment.getCommentContent()));
		
		int commentNo = dao.insertComment(comment);
		
		return commentNo;
	}

}
