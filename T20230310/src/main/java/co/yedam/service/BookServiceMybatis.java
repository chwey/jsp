package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BookMapper;
import co.yedam.vo.BookVO;

public class BookServiceMybatis implements BookService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BookMapper mapper = sqlSession.getMapper(BookMapper.class);

	@Override
	public List<BookVO> bookList() { //목록.
		return null;
	}

	@Override
	public boolean addBook(BookVO vo) { //등록.
		return false;
	}

	@Override
	public BookVO getBookInfo(String bookCode) { //조회.
		return null;
	}

}
