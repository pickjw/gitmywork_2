package com.example.spring02.service.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.memo.dao.MemoDAO;
import com.example.spring02.model.memo.dto.MemoDTO;


/*
 * Spring에서 관리해주는 어노테이션
컨트롤러 : @Controller , @RestController
서비스 : @Service
모델(DAO) : @Repository
*/
@Service
public class MemoServiceImpl implements MemmoService {

	//의존관계 주입 ( 스프링에서 인스턴스 생성)
	@Inject
	MemoDAO memoDao;//DAO 호출 원래=> MemoDAO memoDao = null;

	@Override
	public List<MemoDTO> list() {
		return memoDao.list();
	}

	@Override
	public void insert(MemoDTO dto) {
		memoDao.insert(dto.getWriter(), dto.getMemo());

	}

	@Override
	public MemoDTO memo_view(int idx) {
		return memoDao.memo_view(idx);
	}

	@Override
	public void update(MemoDTO dto) {
		memoDao.update(dto);

	}

	@Override
	public void delete(int idx) {
		memoDao.delete(idx);

	}

}
