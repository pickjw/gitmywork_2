package common;

import javax.servlet.http.Cookie;

public class Util {
	public static String getCookie(Cookie[] cookies, String name) {
		String result="";
		if(cookies != null) {
			//전체 쿠키값 볼경우
			for(int i=0; i<cookies.length; i++) {
				//name만 필요할 경우
				System.out.println("getCookie 반복문확인");
				if(cookies[i].getName().equals("name")){
					result = cookies[i].getValue();
					break;
				} 	
			}
		}
		System.out.println("getCookie 리턴확인");
		return result;
		
	}

}
