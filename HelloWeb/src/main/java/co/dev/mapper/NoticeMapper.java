package co.dev.mapper;

import java.util.List;


import co.dev.vo.NoticeVO;

public interface NoticeMapper {
	//목록
	public List<NoticeVO> noticeList();
	public List<NoticeVO> noticeListWithPaging(int page);
	public int insertNotice(NoticeVO vo); //등록
	public NoticeVO selectNotice(int nid); //단건조회
	public int updateCount(int nid); //조회수증가
	public int getTotalCount(); //전체건수
	public int updateNotice(NoticeVO vo);//글수정
	public int deleteNotice(int nid); //삭제

	
	
}
