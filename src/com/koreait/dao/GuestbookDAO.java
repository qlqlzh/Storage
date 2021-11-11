package com.koreait.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.koreait.vo.GuestbookVO;
import com.koreait.vo.Param;

public class GuestbookDAO {

	private static GuestbookDAO instance = new GuestbookDAO();
	private GuestbookDAO() { }
	public static GuestbookDAO getInstance() {
		return instance;
	}
	
//	InsertService 클래스에서 호출되는 mapper와 테이블에 저장할 데이터가 저장된 객체를 넘겨받고 guestbook.xml 파일의
//	테이블에 글을 저장하는 insert sql 명령을 실행하는 메소드
	public void insert(SqlMapClient mapper, GuestbookVO vo) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 insert() 메소드");
//		insert("실행할 sql 명령의 id"[, sql 명령으로 전달할 데이터])
		mapper.insert("insert", vo);
	}
	
//	SelectService 클래스에서 호출되는 mapper를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글의 개수를 얻어오는
//	select sql 명령을 실행하는 메소드
	public int selectCount(SqlMapClient mapper) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectCount() 메소드");
//		queryForObject(): select sql 명령의 실행 결과가 1건일 때 사용한다. => 결과를 Object 타입으로 얻어온다.
//		queryForList(): select sql 명령의 실행 결과가 여러건일 때 사용한다. => 결과를 List 인터페이스 타입으로 얻어온다.
		return (int) mapper.queryForObject("selectCount");
	}
	
//	SelectService 클래스에서 호출되는 mapper와 1페이지 분량의 시작 인덱스와 마지막 인덱스가 저장된 HashMap 객체를
//	넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 중에서 1페이지 분량에 해당되는 글 목록을 얻어오는 select sql
//	명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectList(SqlMapClient mapper, HashMap<String, Integer> hmap) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectList() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectList", hmap);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 검색어(내용)를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 중에서
//	검색어를 포함하는 글의 개수를 얻어오는 select sql 명령을 실행하는 메소드	
	public int selectCountMemo(SqlMapClient mapper, String item) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectCountMemo() 메소드");
		return (int) mapper.queryForObject("selectCountMemo", item);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 1페이지 분량의 시작 인덱스, 마지막 인덱스, 검색어(내용)가 저장된 
//	Param 클래스 객체를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 중에서 검색어를 포함하는 1페이지 분량에
//	해당되는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectListMemo(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectListMemo() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListMemo", param);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 검색어(이름)를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 중에서
//	검색어를 포함하는 글의 개수를 얻어오는 select sql 명령을 실행하는 메소드	
	public int selectCountName(SqlMapClient mapper, String item) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectCountName() 메소드");
		return (int) mapper.queryForObject("selectCountName", item);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 1페이지 분량의 시작 인덱스, 마지막 인덱스, 검색어(이름)가 저장된 
//	Param 클래스 객체를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 중에서 검색어를 포함하는 1페이지 분량에
//	해당되는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드
	public ArrayList<GuestbookVO> selectListName(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectListName() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListName", param);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 검색어(내용+이름)를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 
//	중에서 검색어를 포함하는 글의 개수를 얻어오는 select sql 명령을 실행하는 메소드	
	public int selectCountMemoName(SqlMapClient mapper, String item) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectCountMemoName() 메소드");
		return (int) mapper.queryForObject("selectCountMemoName", item);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 1페이지 분량의 시작 인덱스, 마지막 인덱스, 검색어가 저장된 
//	Param 클래스 객체를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 중에서 검색어를 포함하는 1페이지 분량에
//	해당되는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드	
	public ArrayList<GuestbookVO> selectListMemoName(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectListMemoName() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListMemoName", param);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 카테고리, 검색어가 저장된 Param 클래스 객체를 넘겨받고 
//	guestbook.xml 파일의 테이블에 저장된 전체 글 중에서 검색어를 포함하는 글의 개수를 얻어오는 select sql
//	명령을 실행하는 메소드		
	public int selectCountMulit(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectCountMulit() 메소드");
		return (int) mapper.queryForObject("selectCountMulit", param);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 1페이지 분량의 시작 인덱스, 마지막 인덱스, 카테고리, 검색어가 
//	저장된 Param 클래스 객체를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 전체 글 중에서 카테고리별 검색어를
//	포함하는 1페이지 분량에 해당되는 글 목록을 얻어오는 select sql 명령을 실행하는 메소드	
	public ArrayList<GuestbookVO> selectListMulti(SqlMapClient mapper, Param param) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectListMulti() 메소드");
		return (ArrayList<GuestbookVO>) mapper.queryForList("selectListMulti", param);
	}
	
//	SelectService 클래스에서 호출되는 mapper와 수정 또는 삭제할 글번호를 넘겨받고 guestbook.xml 파일의 테이블에 
//	저장된 전체 글 중에서 수정 또는 삭제할 글 1건을 얻어오는 select sql 명령을 실행하는 메소드
	public GuestbookVO selectByIdx(SqlMapClient mapper, int idx) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 selectByIdx() 메소드");
		return (GuestbookVO) mapper.queryForObject("selectByIdx", idx);
	}
	
//	DeleteService 클래스에서 호출되는 mapper와 삭제할 글번호를 넘겨받고 guestbook.xml 파일의 테이블에 저장된 
//	전체 글 중에서 글 1건을 삭제하는 delete sql 명령을 실행하는 메소드
	public void delete(SqlMapClient mapper, int idx) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 delete() 메소드");
		mapper.delete("delete", idx);
	}
	
//	UpdateService 클래스에서 호출되는 mapper와 수정할 정보가 저장된 객체를 넘겨받고 guestbook.xml 파일의 테이블에
//	저장된 전체 글 중에서 글 1건을 수정하는 update sql 명령을 실행하는 메소드
	public void update(SqlMapClient mapper, GuestbookVO vo) throws SQLException {
		System.out.println("GuestbookDAO 클래스의 update() 메소드");
		mapper.update("update", vo);
	}

}
