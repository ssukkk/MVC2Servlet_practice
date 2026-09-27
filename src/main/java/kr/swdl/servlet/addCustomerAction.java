package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.CustomerService;

public class addCustomerAction implements Action {
//등록 시켜주는 동작
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String url = "view/addCustomer.jsp"; //등록 실패 시
		int point = 0;
		
		CustomerService service = new CustomerService();
//		service.addCustomer(name, phoneNumber, point);
		//등록 완료
		//정상 등록시 00페이지, 비정상 시 --페이지?
		if(service.addCustomer(name, phoneNumber, point)) {
			url = "view/ok.jsp"; //등록성공 시
		}
		
		return url;
		
	}
	

}
