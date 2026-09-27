package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/controller") //이 서블릿클래스를 /controller라는 주소와 연결해달라는 뜻
public class FrontControllerServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// cmd
		String cmd=request.getParameter("cmd");
		System.out.println("cmd : "+ cmd); //개발자 확인용. 서비스 운영 시 삭제 요망
		//해당 Action 전달 받아서 실행 TDD
		Action a=ActionFactory.getAction(cmd);
		//해당 페이지로 이동
		String url=a.execute(request);
		request.getRequestDispatcher("/"+url).forward(request, response);
	}

}
