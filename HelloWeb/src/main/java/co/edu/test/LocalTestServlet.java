package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{
	
	String str;//필드. 객체생성이 되면 멤버변수
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		str = req.getParameter("msg");
		int num=0;
		resp.setContentType("text/html;charset=utf-8");
		//출력스트림 생성
		PrintWriter out = resp.getWriter();
		out.print("<h3>처리결과(지역변수)</h3>");
		while (num++ < 10) {
			out.print(str + " : " + num + "<br>");
			out.flush(); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		out.print("<h3>Done</h3>");
		out.close();

		
	}
}
