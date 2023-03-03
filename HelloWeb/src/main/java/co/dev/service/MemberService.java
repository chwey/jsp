package co.dev.service;

import java.util.List;

import co.dev.vo.MemberVO;

public interface MemberService {
	//회원목록
	public List<MemberVO> getMembers();
	
}
