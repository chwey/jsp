package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/addInfo")
public class AdditionInfoServ extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//사용자의 입력값: parameter 값이 넘어옴
		//?id=user&pw=1234(Query String: 질의 문자열)
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		String html = "<html><head><title>Header 정보</title></head>";
		html += "<body>";
		html += "<h3>추가적인 정보</h3>";
		html += "<p>입력값은 id: "+ id +", pw: " + pw + "<br>";
		html += "Request Method: "+ req.getMethod() + "<br>";
		html += "Path Info: "+ req.getPathInfo() + "<br>";
		html += "Path translated: "+ req.getPathTranslated() + "<br>";
		html += "Query String: "+ req.getQueryString() + "<br>";
		html += "Content Length: "+ req.getContentLength() + "<br>";
		html += "Content Type: "+ req.getContentType() + "<br>";
		
		html += "</body></html>";
		
		out.print(html);
		out.close();
	}
}
