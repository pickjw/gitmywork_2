package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

/*
Controller, DAO, Service => 스프링에서 관리
@Controller
@Service
@Repository
*/

//현재 클래스를 스프링에서 관리하는 컨트롤러 빈으로 등록함
@Controller
public class MainController {

	// 로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/") // url mapping
	public String main(Model model) {// main이름은 jsp페이지와 맞춘다!
		// Model에 자료 저장 (서블릿의 request 객체에 해당됨)
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		// main.jsp로 포워딩됨 접두사: /WEB-INF/views/ main + 접미사: .jsp
		// /WEB-INF/views/main.jsp
		return "main";
	}

	// @RequestParam : get, post 방식으로 전달된 파라미터 변수
	// request.getParameter("변수명")를 대체하는 코드
	// defaultValue="기본값"
	@RequestMapping("gugu.do") // url mapping @RequestParam 하나만 받기
	public String gugu(Model model, @RequestParam(defaultValue = "2") int dan) {
		// int dan = 7;
		String result = "";
		for (int i = 1; i < 9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		// 모델에 자료저장
		model.addAttribute("result", result);
		// view/test.gogo.jsp 로 포워딩
		return "test/gugu";

	}

	@RequestMapping("test.do")
	public void test() {
		// method name과 같은 페이지로 이동
		// /WEB-INF/views/test.jsp
		// return "test";

	}

	@RequestMapping("/test/doA")
	public String doA(Model model) {
		/*
		 * request.setAttribute("message", "홈페이지 방문을 환영합니다!"); String page =
		 * "/test/doA.jsp"; RequestDispatcher dis = request.getRquestDispatcher(page);
		 * dis.forward(request, response);
		 */
		// 자료저장
		model.addAttribute("message", "홈페이지 방문을 환영합니다!");
		// 포워딩
		return "test/doA";
	}

	@RequestMapping("test/doB")
	public void doB() {
		// 리턴타입이 void인 경우
		// method name과 같은 페이지로 포워딩
		logger.info("doB호출.....!");
	}

	// Model - 전달할 데이터
	// ModelAndView - 데이터와 포워딩 할때 페이지 정보 포함
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		Map<String, Object> map = new HashMap<>();
		map.put("product", new ProductDTO("샤프", 1000));
		// new ModelAndView ("페이지이름", "변수" , 값)
		// views/test/doC.jsp
		return new ModelAndView("test/doC", "map", map);
	}

	@RequestMapping("test/doD")
	public String doD() {
		return "redirect:/test/doE";
	}

	@RequestMapping("test/doE") // doE.jsp로 포워딩
	public void doE() {

	}
	
	//SampleRestController떄문에 일시적으로 막기
	//뷰를 리턴하는 것이 아닌 데이터 자체를 리턴 하는 경우
	//호환성을 위해!!
	/*@ResponseBody// dto를 json으로 변환
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("냉장고", 500000);
	}*/
	
	
	
	

}
