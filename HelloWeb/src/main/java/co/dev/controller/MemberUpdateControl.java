package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pass);
		vo.setName(name);
		vo.setMail(mail);
		System.out.println("입력:" + vo);
		
		MemberService service = new MemberServiceImpl();
		boolean result = service.modifyMember(vo);
		if(result) {
			req.setAttribute("message", "정상처리완료");
		}else {
			req.setAttribute("message", "예외");
		}
		
		try {
			req.getRequestDispatcher("WEB-INF/member/memberUpdateOutput.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
