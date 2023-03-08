package co.dev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;
import co.dev.vo.NoticeVO;
import co.dev.vo.PageDTO;

public class NoticeListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String page = req.getParameter("page");
		
		if(page==null) {
			page = "1";
		}
		
		//글목록. mybatis활용 목록
		NoticeService service = new NoticeServiceMybatis();
		List<NoticeVO> list = service.noticeList(Integer.parseInt(page)); //공지사항 목록
		int total = service.getTotalCount();
		
		req.setAttribute("list", list);
		req.setAttribute("page", new PageDTO(Integer.parseInt(page), total));
		
		try {
			req.getRequestDispatcher("WEB-INF/notice/noticeList.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
