package co.yedam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.service.BookService;
import co.yedam.service.BookServiceMybatis;
import co.yedam.vo.BookVO;

public class BoodAddControl implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookCode = req.getParameter("bookCode");
		String bookTitle = req.getParameter("bookTitle");
		String bookAuthor = req.getParameter("bookAuthor");
		String bookPress = req.getParameter("bookPress");
		String bookDesc = req.getParameter("bookDesc");
		int bookPrice = Integer.parseInt(req.getParameter("bookPrice"));
		
		
		BookVO vo = new BookVO();
		vo.setBookCode(bookCode);
		vo.setBookTitle(bookTitle);
		vo.setBookAuthor(bookAuthor);
		vo.setBookPress(bookPress);
		vo.setBookDesc(bookDesc);
		vo.setBookPrice(bookPrice);
	
		
		BookService service = new BookServiceMybatis();
	
		if(service.addBook(vo)) {
			resp.sendRedirect("bookList.do");
		}
		
	}


}
