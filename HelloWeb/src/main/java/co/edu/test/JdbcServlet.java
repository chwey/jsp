package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		Map<String,Object> result = dao.getEmpInfo(101);
			
		//페이지 출력. 사번 이름 급여 부서
		PrintWriter out = resp.getWriter();
		

		//페이지 작성
		//{키:값},{키:값},{키:값},{키:값} =>result.get("키")값을 반환
		String html = "<html><head><title>Header 정보</title></head>";
		html += "<body>";
		html += "<h3>회원조회</h3>";
		
		html += "employeeid"+ result.get("id")+ "<br>";
		html += "name"+ result.get("firstname")+ " ";
		html += result.get("lastname")+ "<br>";
		html += "salary"+ result.get("salary")+ "<br>";
		html += "jobid"+ result.get("jobid")+ "<br>";
		
		html += "</body></html>";
		
		out.print(html);
		out.print("<a href='temp.html>조회-등록으로 이동</a>");
		out.close();
	}
}
