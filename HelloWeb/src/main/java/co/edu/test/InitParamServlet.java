package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{
	
	String id;
	String pw;
	
	public InitParamServlet() {
		System.out.println("InitParamServlet 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pw = config.getInitParameter("password");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print("파라미터 Id: "+ id);
		out.print("파라미터 pw: "+ pw);
		out.close();
	}
}
