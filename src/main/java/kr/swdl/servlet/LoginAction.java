package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		//나중에 DAO 연결 로그인 처리
		//로그인 여부에 따라 url 달라져야 한다.
		String url="view/ok.jsp";
		//?
		return url;
	}

}
