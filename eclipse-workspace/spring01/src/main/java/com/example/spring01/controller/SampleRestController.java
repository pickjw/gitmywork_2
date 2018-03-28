package com.example.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;
//Spring 4.0부터 사용가능
//뷰를 리턴하는 것이 아닌 json을 리턴
@RestController
public class SampleRestController {
	// 뷰를 리턴하는 것이 아닌 데이터 자체를 리턴 하는 경우
	// @ResponseBody <=이것 없이도  dto를 json으로 변환(현업에서 빈도수 떨어짐)
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("냉장고", 500000);
	}
}
