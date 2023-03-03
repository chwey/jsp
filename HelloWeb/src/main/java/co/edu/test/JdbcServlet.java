package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
		
		//get or post 요청을 구분해서 처리
		//get이면 조회. post면 입력
		int eid = Integer.parseInt(req.getParameter("empId"));
		Map<String, Object> result = dao.getEmpInfo(eid);
		
		String html = "<html><head><title>Header 정보</title></head>";
		html += "<body>";
		html += "<h3>회원조회</h3>";
		
		html += "employeeid"+ result.get("id")+ "<br>";
		html += "name"+ result.get("firstname")+ " ";
		html += result.get("lastname")+ "<br>";
		html += "salary"+ result.get("salary")+ "<br>";
		html += "jobid"+ result.get("jobid")+ "<br>";
		
		html += "</body></html>";
		PrintWriter out = resp.getWriter();
		out.print(html);
		out.print("<a href='temp.html>조회-등록으로 이동</a>");
		out.close();
//		if(req.getMethod().equals("GET")) {
//			//조회용으로 Get방식처리
//			int empId =Integer.parseInt(eid);
//			Set<String> set = result.keySet();//키부분만 set 컬렉션
//			for(String key : set) {
//				System.out.println("key: " + key + ",val: "+ result.get(key));
//			}
//		}else if(req.getMethod().equals("POST")) {
//			Map<String, Object> in = new HashMap<>();
//			in.put("eid", req.getParameter("empId"));
//			in.put("first", req.getParameter("first"));
//			in.put("last", req.getParameter("last"));
//			in.put("hire", req.getParameter("hire"));
//			in.put("job", req.getParameter("job"));
//			in.put("email", req.getParameter("email"));
//		}
		
		//페이지 작성
		//{키:값},{키:값},{키:값},{키:값} =>result.get("키")값을 반환
	}
}
