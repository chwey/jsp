package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dev.service.MemberService;
import co.dev.service.MemberServiceMybatis;
import co.dev.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("uid");
		String pw = req.getParameter("upw");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pw);
		System.out.println("before: " + vo);
		
		MemberService service = new MemberServiceMybatis();
		vo = service.login(vo);
		System.out.println("after: " + vo);
		
		//session 객체를 웹브라우저별로 계속 유지되는 정보를 담아놓기 좋은 객체
		HttpSession session = req.getSession();//요청정보에 있는 세션정보가 있으면 호출, 없으면 세션 객체생성
		session.setAttribute("id", vo.getId());
		
		try {
			resp.sendRedirect("noticeList.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
