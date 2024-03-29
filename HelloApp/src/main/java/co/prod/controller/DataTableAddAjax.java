package co.prod.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.MemberService;
import co.prod.service.MemberServiceMybatis;
import co.prod.vo.EmpVO;

public class DataTableAddAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String salary = request.getParameter("salary");

		EmpVO vo = new EmpVO();
		vo.setFirstName(first);
		vo.setLastName(last);
		vo.setEmail(email);
		vo.setJobId("IT_PROG");
		vo.setHireDate(hireDate);
		vo.setSalary(Integer.parseInt(salary));

		MemberService service = new MemberServiceMybatis();
		boolean result = service.addDataTable(vo);

		Map<String, Object> resultMap = new HashMap<>();
		if (result) {
			resultMap.put("retCode", "Success");
			resultMap.put("reply", vo);
		} else {
			resultMap.put("retCode", "Fail");
			resultMap.put("reply", null);
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(resultMap);

		return json + ".ajax";
	}

}
