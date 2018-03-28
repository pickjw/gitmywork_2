package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		//사용자 입력값 검색
		response.getWriter().write(getJSON(userName));
		System.out.println(userName);
	}

	// JSON파싱 함수(메서드) 구현
	// index에서 요청(request) 한 부분을 JSON의 형태로 응답(response)해준다
	public String getJSON(String userName) {
		if (userName == null) userName = "";
		
		// 데이터값 받아오기
		UserDAO userDAO = new UserDAO();
		// Arraylist 데이터를 저장
		ArrayList<User> userList = userDAO.getSearch(userName);

	
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\" : [");
		
		for (int i = 0; i < userList.size(); i++) {
			// 하나의 회원정보를 배열의 원소형태로 보여준다.
			result.append("[{\"value\" : \"" + userList.get(i).getUserName() + "\"}, ");
			result.append("{\"value\" : \"" + userList.get(i).getUserAge() + "\"}, ");
			result.append("{\"value\" : \"" + userList.get(i).getUserGender() + "\"}, ");
			result.append("{\"value\" : \"" + userList.get(i).getUserEmail() + "\"}], ");

		}
		
		result.append("]}");
		return result.toString();

	}
}

	