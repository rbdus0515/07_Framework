package edu.kh.project.board.model.service;

import java.util.List;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.member.model.dto.Member;

public interface CommentService {

	List<Comment> selectComment(int boardNo);

	int insertComment(Comment comment);

}
