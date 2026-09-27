package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
	//request전달하고 결과를 url 받는다.
	String execute(HttpServletRequest request)
			throws ServletException, IOException ; 
}
