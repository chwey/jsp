package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.common.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO{

	//회원목록
	public List<MemberVO> memberList(){ 
		List<MemberVO> memberList = new ArrayList<>();
		getConn();
		String sql ="select * from members order by id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setMail(rs.getString("mail"));
				
				memberList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConn();
		}
		return memberList;
	}
}
