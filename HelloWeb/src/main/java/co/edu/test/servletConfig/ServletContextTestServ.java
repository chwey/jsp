package co.edu.test.servletConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  톰캣에서 어플리케이션 단위로 정보를 생성
 *  서버가 실행되면서 web.xml 읽어들이고 서블릿, 파라미터 Context 생성
 *  context(어플리케이션)마다 정보를 공유
 *  http 처리는 요청 <-> 응답: 클라이언트 서버간의 연결이 끊어짐
 */


public class ServletContextTestServ extends HttpServlet{
	ServletContext sc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		sc = config.getServletContext();//서버의 servletContext;

	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("sc: " + sc);
		String param = sc.getInitParameter("contextConfig");
		System.out.println("ApplicationContext에 지정된 파라미터 값: " + param);
		
		//어플리케이션의 소속된 서블릿에서 값을 컨텍스트에 값을 지정
		//다른 서블릿에서 값을 확인
		Map<String, Object> map = new HashMap<>();
		map.put("id", "guest");
		map.put("pwd", "1234");
		
		//값을 공유하기위한 메소드 제공 setAttribute/ getAttribute
		sc.setAttribute("param", map);
		
		
		
	}
}
