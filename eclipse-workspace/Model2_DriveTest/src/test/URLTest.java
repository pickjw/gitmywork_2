package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println( URLEncoder.encode("김철수","UTF-8"));
		System.out.println(URLDecoder.decode("%EA%B9%80%EC%B2%A0%EC%88%98","UTF-8"));
	}

}
