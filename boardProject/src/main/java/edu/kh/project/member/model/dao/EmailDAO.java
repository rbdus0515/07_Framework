package edu.kh.project.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int updateAuthKey(Map<String, String> map) {
		
		return sqlSession.update("emailMapper.updateAuthKey", map);
	}

	public int insertAuthKey(Map<String, String> map) {
		
		return sqlSession.insert("emailMapper.insertAuthKey", map);
	}

	public int selectOneAuthKey(Map<String, String> map) {
		
		return sqlSession.selectOne("emailMapper.selectOneAuthKey", map);
	}
}
