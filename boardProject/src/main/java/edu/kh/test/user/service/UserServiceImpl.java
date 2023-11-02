package edu.kh.test.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public List<User> searchUser(String userNo) {
		return dao.searchUser(userNo);
	}
	
}
