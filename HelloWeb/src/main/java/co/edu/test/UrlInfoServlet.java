package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlInfo")
public class UrlInfoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>요청정보의 url </h3>");
		out.print("<br>Request URI:" + req.getRequestURI());
		out.print("<br>Request URL:" + req.getRequestURL());
		out.print("<br>Context Path:" + req.getContextPath());
		out.print("<br>Request Protocol:" + req.getProtocol());
		out.print("<br>Servlet Path:" + req.getServletPath());
		
		out.close();
	}
	
}
