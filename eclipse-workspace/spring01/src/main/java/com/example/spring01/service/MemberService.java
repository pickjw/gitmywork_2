package com.example.spring01.service;

import java.util.List;

/*
Controller, DAO, Service => 스프링에서 관리
@Controller
@Service
@Repository
*/

import com.example.spring01.model.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> memberList();
	public void insertMember(MemberDTO dto);
	public MemberDTO viewMember(String userid);
	public void deleteMember (String userid);
	public void updateMember (MemberDTO dto);
	public boolean checkPw (String userid, String passwd);
	

}
