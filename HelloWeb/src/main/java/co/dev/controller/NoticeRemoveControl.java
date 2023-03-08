package co.dev.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;
import co.dev.service.NoticeService;
import co.dev.service.NoticeServiceMybatis;

public class NoticeRemoveControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String nid = req.getParameter("nid");
		
		NoticeService service = new NoticeServiceMybatis();
		
		service.noticeRemove(Integer.parseInt(nid));
		
		try {
			resp.sendRedirect("noticeList.do");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
