package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MemberDeleteFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("WEB-INF/member/memberDelete.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
