package co.prod.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//ojdbc를 활용해 db connection 객체 사용
//특징: db 요청이 있을때마다 객체 생성 끝나면 반환
//connection 객체: 서버에 미리 생성
//DataSource => Resource 가져오는 룩업
public class DataSource {
	//싱글톤 방식
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {
		
	}
	
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

}
