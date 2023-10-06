package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.AjaxDAO;
import edu.kh.project.member.model.dto.Member;

@Service // 서비스임을 명시 + bean 등록
public class AjaxServiceImpl implements AjaxService {

	@Autowired
	private AjaxDAO dao;
	
	@Override
	public String selectMemberTel(String nickname) {
		return dao.selectMemberTel(nickname);
	}

	// 이메일로 회원정보 조회
	@Override
	public Member selectMember(String email) {
		return dao.selectMember(email);
	}

	@Override
	public int checkEmail(String email) {
		return dao.checkEmail(email);
	}

	@Override
	public int checkNickname(String nickname) {
		return dao.ckeckNickname(nickname);
	}
	
	

}
