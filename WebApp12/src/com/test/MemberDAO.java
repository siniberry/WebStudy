/*========================================
	MemberDAO.java
	- 데이터베이스 액션 처리 전용 클래스
	  (TBL_MEMBER 테이블 전용 DAO)
==========================================*/
package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

public class MemberDAO
{
	private Connection conn;
	
	// 데이터베이스 연결 담당 메소드
	public Connection connection() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
		return conn;
	}
	
	// 데이터 입력 담당 메소드
	public int add(MemberDTO dto) throws SQLException
	{
		// 적용된 행의 갯수(메서드의 반환 값은 SQL 문 실행에 영향을 받는 행 수를 반환)
		int result = 0;
		
		String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
				+ " VALUES(MEMBERSEQ.NEXTVAL, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getTel());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}

	// 회원 리스트 출력 담당 메소드
	public ArrayList<MemberDTO> lists() throws SQLException
	{
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			MemberDTO member = new MemberDTO();
			member.setSid(rs.getString("SID"));
			member.setName(rs.getString("NAME"));
			member.setTel(rs.getString("TEL"));
			
			result.add(member);
		}
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	// 전체 인원 수 확인 담당 메소드 -- int 에는 적용된 행의 갯수가 아니라, 인원수가 들어있음
	public int count() throws SQLException
	{
		int result = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(); //-- executeQuery()가 반환하는 타입은 resultset
		while(rs.next()) //-- 인원수를 구성해야할 때는 단일행으로 넘어오기 때문에 if문으로 구성해도 돼
		{
			result = rs.getInt("COUNT");
		}
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	// 데이터베이스 연결 종료 담당 메소드
	public void close() throws SQLException
	{
		DBConn.close();
	}
	
	// 메소드 추가--------------------------------------------------------------
	
	// 번호 검색 담당 메소드(번호를 통해 회원 데이터 조회)
	//-- 현재... 번호(sid)는 TBL_MEMBER 테이블에서 식별자의 역할을 수행하고 있으며
	//   번호를 통한 검색 결과는 한 명의 회원일 수밖에 없기 때문에
	//   반환 자료형은 MemberDTO 형태로 구성한다.
	public MemberDTO searchMember(String sid) throws SQLException
	{
		MemberDTO result = new MemberDTO();
		
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER WHERE SID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			result.setSid(rs.getString("SID"));
			result.setName(rs.getString("NAME"));
			result.setTel(rs.getString("TEL"));
		}
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	// 메소드 추가
	// 회원 데이터 수정 담당 메소드 
	//-- ★ 수정할 때 번호(sid)가 아니라, 수정할 멤버들 MemberDTO 를 넘겨받아야해
	public int modify(MemberDTO member) throws SQLException
	{
		// 적용된 행의 갯수
		int result = 0;
		
		String sql = "UPDATE TBL_MEMBER SET NAME=?, TEL=? WHERE SID=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getTel());
		pstmt.setString(3, member.getSid());
		
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
	// 메소드 추가
	// 회원 데이터 삭제 담당 메소드 
	public int remove(String sid) throws SQLException
	{
		int result = 0;
		
		String sql = "DELETE FROM TBL_MEMBER WHERE SID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sid);
		
		result = pstmt.executeUpdate();
		
		return result;
	}
	
	// 메소드 추가
	// 자식 테이블의 참조 데이터 레코드 수 확인
	public int refCount(String sid) throws SQLException
	{
		int result = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT"
				+ " FROM TBL_MEMBERSCORE"
				+ " WHERE SID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sid);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())	// is(rs.next())
		{
			result = rs.getInt("COUNT");
		}
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
}
