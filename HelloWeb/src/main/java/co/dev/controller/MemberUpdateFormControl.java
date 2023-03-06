package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MemberUpdateFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("WEB-INF/member/memberUpdate.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
