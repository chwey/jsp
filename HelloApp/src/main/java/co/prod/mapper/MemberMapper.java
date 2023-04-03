package co.prod.mapper;

import java.util.List;

import co.prod.vo.MemberVO;
import co.prod.vo.MembersVO;


public interface MemberMapper {
	//매퍼<MemberMapper.xml)에서 실행할 메소드 정의
	public List<MemberVO> getMembers();
		
	//로그인 용도
	public MemberVO login(MemberVO vo);
	
	//회원정보 삭제
	public int deleteMember(String id);
	
	//회원등록
	public int insertMenber(MemberVO vo);
	
	//list
	public List<MembersVO>memberList();
	public int insertMembers(MembersVO vo);
	public int deleteMembers(String memberId);
}
