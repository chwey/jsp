package co.prod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ReplyVO;

public class ReplySearchAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String rid = request.getParameter("replyNo");
		//mapper는 selectReply(rid)
		ProductService service = new ProductServiceImpl();
		ReplyVO vo = service.getReply(Integer.parseInt(rid));
		
		Gson gson = new GsonBuilder().create();//자바객체를 문자열로 바꿔줌
		String json = gson.toJson(vo);
		
		return json + ".ajax";
	}

}
