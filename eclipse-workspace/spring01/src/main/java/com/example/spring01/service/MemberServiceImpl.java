package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

/*
Controller, DAO, Service => 스프링에서 관리
@Controller
@Service
@Repository
*/

//현재 클래스를 스프링에서 관리하는 service bean으로 설정
 /*
		 Service => 1 DAO
		 Service => many DAO	 
 
 */
@Service
public class MemberServiceImpl implements MemberService {
	
	//dao 인스턴스를 주입시킴-직접 할 경우MemberDAO memberDao = new MemberDAOImpl();
	@Inject
	MemberDAO memberDao;
	
	@Override//MemberController => MemberService => MemberDAO => SqlSession => memberMapper.xml
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}
	
	//ex @Transactional
	@Override
	public void insertMember(MemberDTO dto) {
		memberDao.insertMember(dto);
		//ex 회원탈퇴 및 기타 등등 memberDao.deleteMember(dto.getUserid());
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

	@Override
	public void deleteMember(String userid) {
		memberDao.deleteMember(userid);

	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDao.updateMember(dto);

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		return memberDao.checkPw(userid, passwd);
	}

}
