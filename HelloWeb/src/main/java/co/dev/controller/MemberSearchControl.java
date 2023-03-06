package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.MemberService;
import co.dev.service.MemberServiceImpl;
import co.dev.vo.MemberVO;

public class MemberSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		
		//id를 활용해서 MemberVO 객체를 반환하는 메소드(MemberService, MemberDAO)
		MemberService service = new MemberServiceImpl();
		MemberVO result = service.getMember(id);
		

		req.setAttribute("vo", result);
		String targetPage = "";
		//조회된 결과가 없을 경우: 조회, 수정, 삭제
		if(result == null) {
			req.setAttribute("message", "조회된 결과가 없습니다");
		}
		if(job.equals("search")) {
			if(result == null) {
				targetPage = "WEB-INF/member/memberSearchForm.jsp";
			}else if(result != null){
				targetPage = "WEB-INF/member/memberSearchOutput.jsp";
			}
		}else if(job.equals("update")) {
			targetPage = "WEB-INF/member/memberUpdate.jsp";
		}else if(job.equals("delete")) {
			targetPage = "WEB-INF/member/memberDelete.jsp";
		}
			
		
		//페이지지정
		try {
			req.getRequestDispatcher(targetPage).forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
