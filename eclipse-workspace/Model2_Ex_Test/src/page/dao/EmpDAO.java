package page.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import page.dto.EmpDTO;
import sqlmap.MybatisManager;

public class EmpDAO {
	
	public List<EmpDTO> getEmpList(int start, int end) {
		SqlSession session = MybatisManager.getInstance().openSession();
		//dto 아니면 HashMap을 사용해야함 2개이상 안들어감
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<EmpDTO> items = session.selectList("emp.empList", map);
		session.close();// mybatis 세션닫기
		System.out.println("getEmpList 연결o");// 연결확인
		return items;
		
	}
	
	public int getEmpCount () {
		SqlSession session = MybatisManager.getInstance().openSession();
		int count = session.selectOne("emp.empCount");
		session.close();
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
