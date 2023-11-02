package edu.kh.test.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.kh.test.user.model.vo.User;
import edu.kh.test.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/searchUser")
	public String searchUser(String userNo, Model model) {
		
		List<User> userList = service.searchUser(userNo);
		
		if(!userList.isEmpty()) {
			
			model.addAttribute("userList", userList);
			return "searchSuccess";
			
		} else {
			
			return "searchFail";
			
		}
		
	}
	
}
