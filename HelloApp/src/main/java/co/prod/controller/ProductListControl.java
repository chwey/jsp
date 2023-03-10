package co.prod.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prod.common.Control;
import co.prod.service.ProductService;
import co.prod.service.ProductServiceImpl;
import co.prod.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		List<ProductVO> list = new ArrayList<>();
		ProductService service = new ProductServiceImpl();
		list = service.products();
		
		req.setAttribute("pro", list);
		
		//db 결과 -> attribute("list")
		return "product/productList.tiles"; // 실행할 페이지
		
		
	}

}
