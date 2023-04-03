package co.prod.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.MemberService;
import co.prod.service.MemberServiceMybatis;
import co.prod.vo.MembersVO;

public class MemberRemoveJquery implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String[] members = request.getParameterValues("memberId");
		System.out.println(members);
	
		
		return null;
	}

}
