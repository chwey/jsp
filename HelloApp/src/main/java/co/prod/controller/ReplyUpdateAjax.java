package co.prod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ReplyVO;

public class ReplyUpdateAjax implements Control {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String replyId = request.getParameter("replyId");
		String content = request.getParameter("content");

		ReplyVO vo = new ReplyVO();
		vo.setReplyNo(Integer.parseInt(replyId));
		vo.setReplyContent(content);

		ProductService service = new ProductServiceImpl();
		boolean result = service.updateReply(vo);

		vo = service.getReply(Integer.parseInt(replyId));

		Gson gson = new GsonBuilder().create();

		String json = "";
		if (result) {
			json = gson.toJson(vo);
		} else {
			json = null;
		}
		return json + ".ajax";
	}

}
