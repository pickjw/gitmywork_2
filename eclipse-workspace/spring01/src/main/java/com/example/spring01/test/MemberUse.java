package com.example.spring01.test;

import javax.inject.Inject;

//의존관계 : MemberUse 는 Member에 의존한다!
//강한결합관계
class Member {
	String userid;
	String passwd;
	String name;
	// public Member() {//생성자
	private Member() {// 외부에서 new로 인스턴스를 만들수 없음
	}
	/*private static Member instance;
	public static Member getInstance() {
		if (instance == null) {
		}
		return instance;
	}*/
}
public class MemberUse {
	//느슨한 결합관계
	//의존관계 주입(Dependency Injection, DI)
	//객체 생성, 소멸 (라이프사이클 관리)
	//IoC(Inversion of Control,제어의 역전) 
	//- 객체에 대한 제어권이 개발자 => 스프링으로 이동
	@Inject
	Member m;
	public MemberUse (Member m) {
		
		
	}
/*	public MemberUse() {//생성자
		// Member m = new Member();
		//Member m = Member.getInstance();
	}*/
}
