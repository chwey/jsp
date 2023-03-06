package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MemberInsertFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//회원등록화면호출
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/member/memberInsert.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
		

	}

}
