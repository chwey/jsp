package co.dev.vo;

import lombok.Data;

@Data
public class PageDTO {

	private int startPage; // 첫페이지
	private int endPage; // 마지막페이지
	private boolean prev, next; // 이전, 다음페이지
	private int page; // 현재페이지
	
	public PageDTO(int page, int total) {
		//total: 235건 --> 24page
		this.page = page;
		this.endPage = (int) Math.ceil(page/10.0) * 10; //1~10 => 10
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) Math.ceil(total * 1.0 / 10);
		if(this.endPage > realEnd) {
			this.endPage = realEnd; // 22page -> 24
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd; // 3 -> 10
	}
}
