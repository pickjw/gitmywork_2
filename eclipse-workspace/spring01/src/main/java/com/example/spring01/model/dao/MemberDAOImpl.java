package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;

//현재 클래스를 스프링에서 관리하는 dao dean 으로 설정
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	/*
	Controller, DAO, Service => 스프링에서 관리
	@Controller
	@Service
	@Repository
	*/
	
	/*인터페이스    구현클래스
	 MemberDAO	MemberImpl =>유지보수
	 
	 강한결합관계
     A   =>  B
     
     느스한 결합 관계(유연함-유지보수)
     	인터페이스 => 클래스
     A =>  B  =>  c
	MemberController => MemberService => MemberDAO => SqlSession
	=> memberMapper.xml
	
	MemberDAO => SqlSession
	
	(Dependency Injection, DI * 중요-의존관계 역전)
	MemberDAO <= SqlSession <= Spring Framework(의존관계 주입 하면 방향 바뀜)
	 */
	@Inject //의존관계주입 (Dependency Injection, DI * 중요-의존관계 역전)
	SqlSession sqlSession;
	
	@Override//MemberController => MemberService => MemberDAO => SqlSession => memberMapper.xml
	public List<MemberDTO> memberList() { //제어권을 spring에게 넘겨줌
		return sqlSession.selectList("member.memberList");
	}
	

	@Override
	public void insertMember(MemberDTO dto) {
		//auto commit, auto close
		sqlSession.insert("member.insertMember", dto);
	}

	@Override
	public MemberDTO viewMember(String userid) {
		//레코드 1개 : selectOne(), 2개이상 : selectList()
		return sqlSession.selectOne("member.viewMember", userid);
	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("member.deleteMember", userid);

	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update("member.updateMember", dto);

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		boolean result = false;
		//mapper에 2개 이상의 자료를 전달 할떄 : map,dto 사용
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count=sqlSession.selectOne("member.checkPw",map);
		//비밀번호가 맞으면 1 = true , 틀리면 0 =  false 리턴
		if (count == 1) result = true;
		return result;
	}

}
