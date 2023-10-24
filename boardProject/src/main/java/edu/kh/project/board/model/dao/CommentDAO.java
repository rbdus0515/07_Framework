package edu.kh.project.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 댓글 목록 조회 DAO
	 * @param boardNo
	 * @return
	 */
	public List<Comment> selectComment(int boardNo) {
		return sqlSession.selectOne("boardMapper.selectComment", boardNo);
	}

	/** 댓글 등록 DAO
	 * @param comment
	 * @return
	 */
	public int insertComment(Comment comment) {
		return sqlSession.insert("boardMapper.insertCommnet", comment);
	}


}
