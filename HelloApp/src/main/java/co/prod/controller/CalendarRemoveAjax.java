package co.prod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.CalendarVO;

public class CalendarRemoveAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		CalendarVO vo = new CalendarVO();
		vo.setTitle(title);
		vo.setStart(start);
		vo.setEnd(end);
		
		ProductService service = new ProductServiceImpl();
		
		boolean result = service.removeEvent(vo);
		
		String json="";
		if(result) {
			json = "{\"retCode\":\"Success\"}";
		}else {
			json = "{\"retCode\":\"Fail\"}";
		}
		return json + ".ajax";
	}

}
