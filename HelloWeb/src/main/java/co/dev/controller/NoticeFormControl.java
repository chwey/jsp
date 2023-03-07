package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class NoticeFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.getRequestDispatcher("WEB-INF/notice/noticeForm.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
