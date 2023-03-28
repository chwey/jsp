package co.prod.service;

import java.util.List;

import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public interface ProductService {
	//목록
	public List<ProductVO> products();
	
	public ProductVO getProduct(String code);
	
	//상품에 대한 댓글목록
	public List<ReplyVO> replyList(String code);
	//댓글삭제
	public boolean removeReply(int replyId);
	//댓글등록
	public boolean addReply(ReplyVO vo);
	
}
