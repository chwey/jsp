package co.prod.service;

import java.util.List;

import co.prod.vo.EmpVO;
import co.prod.vo.MemberVO;
import co.prod.vo.MembersVO;


public interface MemberService {
	//회원목록
	public List<MemberVO> getMembers();
	//회원등록
	public boolean addMember(MemberVO vo);
	//회원조회
	public MemberVO getMember(String id);
	//회원수정처리
	public boolean modifyMember(MemberVO vo);
	//회원삭제처리
	public boolean removeMember(String id);
	// id/pw 로그인처리
	public MemberVO login(MemberVO vo);
	
	//memberlist
	public List<MembersVO> memberList();
	//등록
	public boolean addMembers(MembersVO vo);
	//삭제
	public boolean removeMembersAry(String[] users);
	
	//사원목록
	public List<EmpVO> employeeList();
	//추가
	public boolean addDataTable(EmpVO vo);
	
}
