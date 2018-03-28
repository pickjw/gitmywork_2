package com.example.spring01.model.dao;

import java.util.List;
import com.example.spring01.model.dto.MemberDTO;

/*
Controller, DAO, Service => 스프링에서 관리
@Controller
@Service
@Repository
*/
//인터페이스    구현클래스
	/*
	 MemberDAO	MemberImpl =>유지보수
	 
	 강한결합관계
   A   =>  B
   
   느스한 결합 관계(유연함-유지보수)
   	인터페이스 => 클래스
   A =>  B  =>  c
   
   */

public interface MemberDAO {
	 public List<MemberDTO> memberList();
	 public void insertMember(MemberDTO dto);
	 public MemberDTO viewMember (String userid);
	 public void deleteMember(String userid);
	 public void updateMember(MemberDTO dto);
	 public boolean checkPw(String userid, String passwd);

}
