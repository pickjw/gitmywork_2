package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

/*
 		스프링에서 관리하는 bean
 		1.single ton 객체 - only one
 		2.영속적인 객체(persistence object)
 		new MemberDTO(); => X 영속적이지 않음 값이 가변적임!
 		
		Controller, DAO, Service => 스프링에서 관리
		@Controller
		@Service
		@Repository
*/
@Controller // 스프링에서 관리하는 컨트롤러 빈으로 등록
public class MemberController {

	// MemberService에 인스턴스 주입시킴
	@Inject // 의존관계주입 (Dependency Injection, DI * 중요-의존관계 역전) 없을 경우 null
	MemberService memberService;

	/*
	 * @Inject MemberDAO memberDao;
	 */

	@RequestMapping("/member/list.do") // url mapping
	public String memberList(Model model) {
		// MemberController => MemberService => MemberDAO => SqlSession =>
		// memberMapper.xml
		List<MemberDTO> list = memberService.memberList();
		model.addAttribute("list", list);
		// WEB-INF/view/member/member_list.jsp로 포워딩
		return "member/member_list";
	}

	@RequestMapping("/member/write.do") // url mapping
	public String write() {
		// WEB-INF/view/ member/write. jsp로 포워딩
		return "member/write";
	}

	@RequestMapping("/member/insert.do") // url mapping
	/*
	 * insert.do => MemberController => MemberService => MemberServiceImpl =>
	 * MemberDAO => MemberDAOImpl => memberMapper.xml
	 */
	// 전체적인 복수의 값을 받을 경우
	public String insert(@ModelAttribute MemberDTO dto) {// @ModelAttribute생략가능
		/*
		 * public String insert( @RequestParam String userid, @RequestParam String
		 * passwd , @RequestParam String name, @RequestParam String email) {
		 */
		// 앞의 태그의 name과 같아야 함 - 개별적으로 값을 받아야 할 경우
		// System.out.println(dto);
		memberService.insertMember(dto);
		// memberDao.insertMember(dto);
		return "redirect:/member/list.do";
	}

	// @RequestParam : request.getParameter("변수명") 대체
	@RequestMapping("/member/view.do") // url mapping
	public String view(@RequestParam String userid, Model model) {// @RequestParam 생략가능
		// 모델에 자료 저장
		model.addAttribute("dto", memberService.viewMember(userid));
		// view .jsp로 포워딩
		return "member/view";
	}

	@RequestMapping("/member/update.do")
	public String update(MemberDTO dto, Model model) {
		// 비밀번호 체크
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		
		if (result) {// 비밀번호가 맞으면
			// 회원정보수정
			memberService.updateMember(dto);
			// 수정 후 목록으로 이동
			return "redirect:/member/list.do"; //redirect
		} else { //비밀번호가 틀리면
			model.addAttribute("dto", dto);
			model.addAttribute("join_date"
					, memberService.viewMember(dto.getUserid()).getJoin_date());
			model.addAttribute("message", "비밀번호를 확인하세요!");
			return "member/view"; //forward
		}
	}
	
	@RequestMapping("/member/delete.do")
	public String delete (String userid, String passwd, Model model) {
		boolean result = memberService.checkPw(userid, passwd);
		if(result) {// 비밀번호가 맞으면 삭제
			memberService.deleteMember(userid);
			return "redirect:/member/list.do";
			
		}else { //비밀번호가 틀리면 되돌아감
			model.addAttribute("message", "비밀번호를 확인하세요!");
			model.addAttribute("dto"
					, memberService.viewMember(userid));
			return "member/view";
		}
	}
	
	
	
	
	
	
	
}
