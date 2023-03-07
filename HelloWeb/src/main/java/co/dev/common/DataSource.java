package co.dev.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource { //싱글톤 클래스
	
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
	
	return sqlSessionFactory; //sqlsession 여러개 담고있는 pool;
	}
}
