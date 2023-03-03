package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	//url패턴과 실행 컨트롤러 등록
	//url - controller: map 등록
	Map<String, Control>map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/login.do", new LoginControl());
		//회원목록
		map.put("/memberList.do", new MemberListControl());
		//사원목록
		map.put("/empList.do", new EmpListControl()); // member/empList.jsp
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//url - control 매칭
		String uri = req.getRequestURI();// http://localhost:8080/HelloWeb/main.do
		String context = req.getContextPath(); // /HelloWeb
		String path = uri.substring(context.length()); // main.do
		System.out.println(path);
		
		Control sub = map.get(path);//Parent parent = new Child();
		sub.execute(req, resp);
	}
	
}
