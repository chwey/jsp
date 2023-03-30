package co.prod.mapper;

import java.util.List;
import java.util.Map;

import co.prod.vo.CalendarVO;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductMapper {
	//상품목록
	public List<ProductVO> productList();
	public ProductVO selectProduct(String code);
	
	//댓글목록
	public List<ReplyVO> replyList(String code);
	//댓글삭제
	public int deleteReply(int replyId);
	//댓글등록
	public int insertReply(ReplyVO vo);
	
	public ReplyVO selectReply(int replyId);
	
	public int modifyReply(ReplyVO vo);
	
	//chart.부서별인원현황
	public List<Map<String, Object>> chartInfo();
	
	public List<CalendarVO> calendarList();
	
	public int insertEvent(CalendarVO vo);
	
	public int deleteEvent(CalendarVO vo);

}
