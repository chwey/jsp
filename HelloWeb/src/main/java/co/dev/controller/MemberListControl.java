package co.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.service.MemberServiceMybatis;
import co.dev.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 회원목록
		// /WEB-INF/member/memberList.jsp
		MemberService service = new MemberServiceMybatis();
		List<MemberVO> list = service.getMembers();
		
		req.setAttribute("members", list); // context: sc.setAttribute("param", map)
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/member/memberList.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} //페이지 재지정
		

	}

}
