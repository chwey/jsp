package co.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.prod.common.DataSource;
import co.prod.mapper.ProductMapper;
import co.prod.vo.ProductVO;

public class ProductServiceImpl implements ProductService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession이 불러오고 true를 하면 자동 커밋이 됨
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> products() {
		return mapper.productList();
	}

}
