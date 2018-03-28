package com.example.spring01.controller;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//JUnit 4 버젼으로 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//환경설정파일
@ContextConfiguration (locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MainControllerTest {
	@Inject //의존관계 주입(DI), 제어권의 역전 (IoC)
	WebApplicationContext wac;
	MockMvc mocMvc; //mvc태스트
	//test 전에 실행되는 코드
	@Before //JUnite
	public void setup() throws Exception {
		//mvc 테스트를 위한 인스턴스 생성
		mocMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	// JUnit이 테스트 하는 코드
	@Test
	public void testMain()  throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}

	@Test
	public void testGugu()  throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/gugu.do"));
	}

	@Test
	public void testTest()  throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/test.do"));
	}

	@Test
	public void testDoA()  throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/test/doA"));
	}

	@Test
	public void testDoB()  throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/test/doB"));
	}

	@Test
	public void testDoC()  throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/test/doC"));
	}

	@Test
	public void testDoD() throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/test/doD"));
	}

	@Test
	public void testDoE()  throws Exception {
		mocMvc.perform(MockMvcRequestBuilders.get("/test/doE"));
	}

}
