package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberDeleteControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		
		//MemberService, MemberDAO
		MemberService service = new MemberServiceImpl();
		
		if(service.removeMember(id)) {
			req.setAttribute("message", "정상처리완료");
		}else {
			req.setAttribute("message", "예외");
		}
		
		//페이지 재지정
		try {
			req.getRequestDispatcher("WEB-INF/member/memberDeleteOutput.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
