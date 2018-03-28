package memo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import memo.dto.MemoDTO;
import model.MemberDTO;
import sqlmap.MybatisManager;

public class MemoDAO {
	//ArrayList 에러 => List로만 써야함
	public List<MemoDTO> getListMemo(String searchkey, String search) {
		//mybatis 실행객체 생성
		// MybatisManager.getInstance() => SqlSessionFactory
		SqlSession session = MybatisManager.getInstance().openSession();//전역변수 설정시 에러 발생 확률이 높아 지기에 하지 않는다
		List<MemoDTO> list = null;
		try {
			if(searchkey.equals("writer_memo")) {//이름+메모로 검색
				//memo.xml에 저장된 sql 문장을 실행  
				//memo라는 namespace 에있는  id="listAll" 
				list= session.selectList("memo.listAll", search);// namespace.id
				System.out.println("getListMemo listAll 연결o");//연결확인
			}else {
				Map<String,String> map = new HashMap<>();
				map.put("searchkey", searchkey); //검색옵션
				map.put("search", search);	//검색 키워드
				//입력매개 변수는 1개만 전달할수 있음
				list= session.selectList("memo.list", map);// namespace.id
				System.out.println("getListMemo list 연결o");//연결확인	
			}
			//공백문자 처리 (스페이스 2개를 변환) &&&&&태그문자처리=?<xmp> 꺠짐방지
			//select 방법
			for(MemoDTO mdto : list) { //List나 ArrayList의 경우 반복문 사용해야함
				String writer = mdto.getWriter();
				String memo = mdto.getMemo();
				//공백문자 처리 (스페이스 2개를 변환)
				writer = writer.replace("  ", "&nbsp;&nbsp;");
				memo = memo.replace("  ", "&nbsp;&nbsp;");	
				//태그문자처리=?<xmp> 꺠짐방지
				writer = writer.replace("<", "&lt;");//Less Than ~보다 작다
				writer = writer.replace(">", "&gt;");//Greater Than ~보다 크다
				memo = memo.replace("<", "&lt;");
				memo = memo.replace(">", "&gt;");
				//키워드에 색상처리 =>*순서가 중요함 태그문자 처리떄문에 무력화 되기에
				//*태그 밑으로 배치해야한다
				if(searchkey.equals("writer") || searchkey.equals("memo") || searchkey.equals("writer_memo")) {
					if(memo.indexOf(search) != -1) {
						writer=writer.replace(search, "<font color='red'>"+search+"</font>");
						memo=memo.replace(search, "<font color='red'>"+search+"</font>");
					}
				}
				mdto.setWriter(writer);//공백 및 태그처리 저장
				mdto.setMemo(memo);//공백 및 태그처리 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		//mybatis 객체 닫기
		return list;
	}
	
	
	//insert 처리 함수
	public void getInsertMemo (MemoDTO mdto) {
		//mybatis 실행객체 생성
		SqlSession session = MybatisManager.getInstance().openSession(); //전역변수 설정시 에러 발생 확률이 높아 지기에 하지 않는다
		/*공백문자 처리 (스페이스 2개를 변환) &&&&&태그문자처리=?<xmp> 꺠짐방지
		insert 방법
		String writer = mdto.getWriter();
		String memo = mdto.getMemo();
		//공백문자 처리 (스페이스 2개를 변환)
		writer = writer.replace("  ", "&nbsp;&nbsp;");
		memo = memo.replace("  ", "&nbsp;&nbsp;");	
		//태그문자처리=?<xmp> 꺠짐방지
		writer = writer.replace("<", "&lt;");//Less Than ~보다 작다
		writer = writer.replace(">", "&gt;");//Greater Than ~보다 크다
		memo = memo.replace("<", "&lt;");
		memo = memo.replace(">", "&gt;");
		mdto.setWriter(writer);
		mdto.setMemo(memo);*/
		
		//memo.xml에 저장된 sql 문장을 실행 
		//memo라는 namespace 에있는  id="insert" 
		session.insert("memo.insert",mdto); //레코드 추가(값mdto)- 항상 1개 추가 mdto.getWriter(), mdto.getMemo()=>안됨! 금지!
		session.commit();//수동커밋 => 필수 사항 
		session.close();//mybatis세션닫기  => 필수 사항 
		System.out.println("getInsertMemo 연결o");//연결확인
	}

	
	//view.do 메서드
	public MemoDTO getViewMemo (int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
	  /*selectList() 레코드 2개 이상 목록가져오기
		selectOne() 레코드가 1개 이*/
		MemoDTO mdto = session.selectOne("memo.view", idx);
		session.close();
		System.out.println("getViewMemo 연결o");//연결확인
		return mdto;						
	}
	
	
	//update.do 메서드
	public void  getUpdateMemo (MemoDTO mdto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.update("memo.update", mdto);//레코드 업데이트 수정
		session.commit();//수동커밋 => 필수 사항 
		session.close();//mybatis세션닫기  => 필수 사항 
		System.out.println("getUpdateMemo 연결o");//연결확인	
	}
	
	//delete.do 메서드
	public void getDeleteMemo (int idx) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.update("memo.delete", idx);//레코드 삭제
		session.commit();//수동커밋 => 필수 사항 
		session.close();//mybatis세션닫기  => 필수 사항 
		System.out.println("getDeleteMemo 연결o");//연결확인	
	}
	
	
	
	
}
