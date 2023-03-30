package co.prod.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.ProductMapper;
import co.prod.vo.CalendarVO;
import co.prod.vo.ProductVO;
import co.prod.vo.ReplyVO;

public class ProductServiceImpl implements ProductService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession이 불러오고 true를 하면 자동 커밋이 됨
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> products() {
		return mapper.productList();
	}

	@Override
	public ProductVO getProduct(String code) {
		
		return mapper.selectProduct(code);
	}

	@Override
	public List<ReplyVO> replyList(String code) {
	
		return mapper.replyList(code);
	}

	@Override
	public boolean removeReply(int replyId) {
		
		return mapper.deleteReply(replyId) == 1;
	}

	@Override
	public boolean addReply(ReplyVO vo) {
		
		return mapper.insertReply(vo) == 1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		
		return mapper.selectReply(replyId);
	}

	@Override
	public boolean updateReply(ReplyVO vo) {
		
		return mapper.modifyReply(vo) == 1;
	}

	@Override
	public List<Map<String, Object>> chartInfo() {
		
		return mapper.chartInfo();
	}

	@Override
	public List<CalendarVO> calendarList() {
		
		return mapper.calendarList();
	}

	@Override
	public boolean addEvent(CalendarVO vo) {
		
		return mapper.insertEvent(vo) == 1;
	}

}
