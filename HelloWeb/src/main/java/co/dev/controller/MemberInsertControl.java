package co.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//회원정보 등록: MemberService -> MemberDAO
		//사용자입력값(id, pass, name, mail)
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pass);
		vo.setName(name);
		vo.setMail(mail);
		System.out.println("입력: " + vo);
		
		MemberService service = new MemberServiceImpl();
		boolean result = service.addMember(vo);
		System.out.println(result);
		if(result) {
			System.out.println("성공");
			req.setAttribute("message", "성공");
			req.setAttribute("id", vo.getId());
		}else {
			System.out.println("예외");
			req.setAttribute("message", "예외");
			
		}
		//요청재지정. RequsetDispatcher
		RequestDispatcher rd = 
				req.getRequestDispatcher("WEB-INF/member/memberinsertOutput.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
