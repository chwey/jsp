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
import co.prod.vo.MembersVO;

public class MemberAddJquery implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String passwd = request.getParameter("pw");
		
		MembersVO vo = new MembersVO();
		vo.setMemberId(id);
		vo.setMemberName(name);
		vo.setMemberTel(tel);
		vo.setMemberAddr(addr);
		vo.setMemberPw(passwd);
		System.out.println("===========vo : "+vo);
		MemberService service = new MemberServiceMybatis();
		
		boolean result = service.addMembers(vo);
		
		Gson gson = new GsonBuilder().create();
		String json = "";
		Map<String, Object> resultMap= new HashMap<>();
		if(result) {
			resultMap.put("retCode", "Success");
			resultMap.put("reply", vo);
		}else {
			resultMap.put("retCode", "Fail");
			resultMap.put("reply", null);
		}
		json = gson.toJson(resultMap);
		
		return json + ".ajax";
	}

}
