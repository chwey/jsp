package co.prod.common;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.controller.CalendarAddAjax;
import co.prod.controller.CalendarAjax;
import co.prod.controller.CalendarForm;
import co.prod.controller.CalendarRemoveAjax;
import co.prod.controller.ChartAjax;
import co.prod.controller.ChartControl;
import co.prod.controller.CovidForm;
import co.prod.controller.DataTableAddAjax;
import co.prod.controller.DataTableAjax;
import co.prod.controller.DataTableForm;
import co.prod.controller.MapForm;
import co.prod.controller.MemberAddAjax;
import co.prod.controller.MemberAddJquery;
import co.prod.controller.MemberJquery;
import co.prod.controller.MemberListAjax;
import co.prod.controller.MemberListControl;
import co.prod.controller.MemberListJquery;
import co.prod.controller.MemberRemoveAjax;
import co.prod.controller.MemberRemoveJquery;
import co.prod.controller.MembersControl;
import co.prod.controller.ProductInfoControl;
import co.prod.controller.ProductListControl;
import co.prod.controller.ReplyAddAjax;
import co.prod.controller.ReplyListAjax;
import co.prod.controller.ReplyRemoveAjax;
import co.prod.controller.ReplySearchAjax;
import co.prod.controller.ReplyUpdateAjax;

public class FrontController extends HttpServlet{
	
	private Map<String, Control> map;
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//url <-> control
		map.put("/memberList.do", new MemberListControl());
		map.put("/members.do", new MembersControl());
		//ajax 호출(SPA 처리)
		map.put("/memberListAjax.do", new MemberListAjax());
		map.put("/memberRemoveAjax.do", new MemberRemoveAjax());
		map.put("/memberAddAjax.do", new MemberAddAjax());
		
		//jquery용 ajax
		map.put("/memberJquery.do", new MemberJquery());
		//목록을 가지고 오도록 memberListJquery.do
		map.put("/memberListJquery.do", new MemberListJquery());
		//추가
		map.put("/memberAddJquery.do", new MemberAddJquery());
		//삭제
		map.put("/memberRemoveJquery.do", new MemberRemoveJquery());
		
		
		//datatable 활용
		//dataTableForm.do=>화면출력
		map.put("/dataTableForm.do", new DataTableForm());
		//dataTableAjax.do=>데이터출력
		map.put("/dataTableAjax.do", new DataTableAjax());
		//등록
		map.put("/dataTableAddAjax.do", new DataTableAddAjax());
		
		//상품목록
		map.put("/productList.do", new ProductListControl());
		//상품한건정보
		map.put("/productInfo.do", new ProductInfoControl());
		
		//상품댓글정보 목록
		map.put("/replyListAjax.do", new ReplyListAjax());
		//상품댓글삭제
		map.put("/replyRemoveAjax.do", new ReplyRemoveAjax());
		//상품댓글등록
		map.put("/replyAddAjax.do", new ReplyAddAjax());
		//상품댓글번호조회
		map.put("/replySearchAjax.do", new ReplySearchAjax());
		//수정
		map.put("/replyUpdateAjax.do", new ReplyUpdateAjax());
		
		//chart
		map.put("/chart.do", new ChartControl());
		//chart 데이터
		map.put("/chartAjax.do", new ChartAjax());
		//covid
		map.put("/covid19.do", new CovidForm());
		//map api
		map.put("/map.do", new MapForm());
		//calendar
		map.put("/calendar.do", new CalendarForm());
		
		map.put("/calendarAjax.do", new CalendarAjax());
		
		map.put("/calendarAddAjax.do", new CalendarAddAjax());
		
		map.put("/calendarRemoveAjax.do", new CalendarRemoveAjax());
		
		
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String page = uri.substring(context.length());
		System.out.println("do page: " + page);
		
		Control command = map.get(page);
		String viewPage = command.exec(req, resp); // product/productList.tiles
		
		if(viewPage.endsWith(".jsp")) {
			viewPage = "/WEB-INF/views/" + viewPage;
//		}else if(viewPage.endsWith(".titles")) { //members.do(...tiles)
			//viewPage = "/" + viewPage;
			
		}else if(viewPage.endsWith(".ajax")) {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().append(viewPage.substring(0,viewPage.length()-5));
			return;
		}
		
		//페이지 재지정
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
}
