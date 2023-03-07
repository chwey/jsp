package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;
import co.dev.vo.NoticeVO;

public class NoticeSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String nid = req.getParameter("nid");
		
		NoticeService service = new NoticeServiceMybatis();
		NoticeVO vo = service.getNotice(Integer.parseInt(nid));
		
		System.out.println(vo);
		req.setAttribute("notice", vo);
		
		try {
			req.getRequestDispatcher("WEB-INF/notice/notice.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
