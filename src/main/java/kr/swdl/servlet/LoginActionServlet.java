package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginAction")
public class LoginActionServlet extends HttpServlet {	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append(request.getMethod());
		//로그인 처리 DAO
		request.getRequestDispatcher("/view/ok.jsp")
		     .forward(request, response);
//		response.sendRedirect("view/ok.jsp");
	}
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//	protected void doPost(HttpServletRequest request, 
//			HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("POST: ");
//	}

}
