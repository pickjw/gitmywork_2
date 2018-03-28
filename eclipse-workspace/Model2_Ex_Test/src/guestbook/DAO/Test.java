package guestbook.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import model.MemberDTO;

public interface Test {
	@Select("select * from guestbook")
	public List<MemberDTO> getList();

}
