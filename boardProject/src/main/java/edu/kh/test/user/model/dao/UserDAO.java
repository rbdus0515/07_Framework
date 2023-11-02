package edu.kh.test.user.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.test.user.model.vo.User;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<User> searchUser(String userNo) {
		return sqlSession.selectList("userMapper.searchUser", userNo);
	}

}
