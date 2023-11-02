package edu.kh.test.user.service;

import java.util.List;

import edu.kh.test.user.model.vo.User;

public interface UserService {
	
	List<User> searchUser(String userNo);

}
