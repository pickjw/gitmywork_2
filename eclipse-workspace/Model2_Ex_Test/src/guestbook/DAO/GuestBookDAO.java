package guestbook.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import guestbook.dto.GuestBookDTO;
import sqlmap.MybatisManager;

public class GuestBookDAO {

	// List.do 메서드 작성
	// 방명록 목록을 리턴
	public List<GuestBookDTO> getList(String searchkey, String search) {
		// mybatis실행객체
		SqlSession session = MybatisManager.getInstance().openSession();
		// mybatis에서는 반드시 List 사용 (ArrayList 사용금지)
		// selectList("네임스페이스.아이디") 생략가능함 => selectList("gbList") =>guestbook.xml
		List<GuestBookDTO> list = null;
		if(searchkey.equals("name_content")) {//이름 + 내용
			list = session.selectList("guestbook.gbListAll","%"+search+"%" );
		}else {
			//mybatis 의 method는 2개 이상의 parameter를 전달할수 없음
			Map<String,String> map = new HashMap<>();
			//map.put(key,value) key 변수명, value 값
			map.put("searchkey", searchkey);
			map.put("search", "%"+search+"%");
			list = session.selectList("guestbook.gbList",map );
		}
		
		for (GuestBookDTO gdto : list) {
			String gb_content = gdto.getGb_content();
			String gb_name = gdto.getGb_name();
			// 태그 문자 처리 XSS(crosss Site Script)공격방어
			gb_content = gb_content.replace("<", "&lt;");
			gb_content = gb_content.replace(">", "&gt;");
			gb_name = gb_name.replace("<", "&lt;");
			gb_name = gb_name.replace(">", "&gt;");
			// 공백 문자 처리
			gb_content = gb_content.replace("  ", "&nbsp;&nbsp;");
			gb_name = gb_content.replace("  ", "&nbsp;&nbsp;");
			// 줄바꿈 처리replace(A,B) A를 B로 변경
			gb_content = gb_content.replace("\n", "<br>");
			gb_name = gb_content.replace("\n", "<br>");
			//키워드 색상 처리
			if( !searchkey.equals("gb_name")) {
				gb_content = gb_content.replace(search, "<span style='color:red'>"+search+"</span>");
			}
			gdto.setGb_content(gb_content);
			gdto.setGb_content(gb_name);
		}
		session.close();// mybatis 세션닫기
		System.out.println("getList 연결o");// 연결확인
		return list;

	}

	// insert.do 메서드 작성
	//리스트 목록 추가
	public void getGbInsert(GuestBookDTO gdto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("guestbook.gbInsert", gdto);
		session.commit();// 수동커밋
		session.close();// 닫기
		System.out.println("getGbInsert 연결o");// 연결확인

	}

	// passwd_ckeck.do 작성
	//비밀번호 체크  (idx 게시물 번호 , gb_passwd 사용자가 입력한 패스워드
	public boolean getPassCheck(int idx, String gb_passwd) {
		boolean result = false;
		//mybatis 실행 객체
		SqlSession session = MybatisManager.getInstance().openSession();
		//DTO안에 idx, gb_passwd 값넣기
		GuestBookDTO gdto = new GuestBookDTO();
		gdto.setIdx(idx);
		gdto.setGb_passwd(gb_passwd);
		//레코드가 1개가 리턴 될 경우 selectOne=>레코드가 1개
		int count = session.selectOne("guestbook.passwdCheck",gdto);
		session.close();//mybatis session 닫기
		System.out.println("getPassCheck 연결o");// 연결확인
		if (count ==1) {
			result = true;
			System.out.println("비밀번호 맞음o");// 연결확인
		}
		return result;
		
	}
	
	//개시물읠 상세 정보 (idx:게시물번호)
	public GuestBookDTO getGbDetail (int idx) {
		GuestBookDTO gdto = new GuestBookDTO();
		SqlSession session = MybatisManager.getInstance().openSession();
		gdto = session.selectOne("guestbook.gbDetail", idx);
		session.close();
		System.out.println("getGbDetail 연결o");// 연결확인
		return gdto;
	}
	
	//게시물 수정   update.do 
	public void getGbUpdate (GuestBookDTO gdto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.update("guestbook.gbUpdate", gdto);
		//insert,update,delete 명령어는 반드시  commit을 해야함
		session.commit();// 수동커밋
		session.close();// 닫기
		System.out.println("getGbUpdate 연결o");// 연결확인
	}
	
	//게시물 삭제 delete.do
	public void getGbDelete (int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.delete("guestbook.gbDelete", idx);
		//insert,update,delete 명령어는 반드시  commit을 해야함
		session.commit();// 수동커밋
		session.close();// 닫기
		System.out.println("getGbDelete 연결o");// 연결확인
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
