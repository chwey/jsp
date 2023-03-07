package co.dev.mapper;

import java.util.List;

import co.dev.vo.MemberVO;

public interface MemberMapper {
	//매퍼<MemberMapper.xml)에서 실행할 메소드 정의
	public List<MemberVO> getMembers();
	

}
