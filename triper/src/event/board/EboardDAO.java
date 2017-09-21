package event.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EboardDAO {

	private Connection conn;
	private ResultSet rs;
	
	public EboardDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@192.168.0.125:1521:xe";
			String dbID = "triper";
			String dbPassword = "triper";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/*	public String getDate() {
		String sql="select to_date(sysdate, 'YY-MM-DD') from dual";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getString(1); //현재날짜 반환
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; //DB 오류
	}*/
	
	public int getNext() {
		String sql="select ebNum from event_board order by ebNum desc"; // 마지막에 쓰인 글 번호 가져옴
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1) + 1; // 다음 게시글 번호
			}
			return 1; // 첫번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류
	}
	
	public int write(String ebTitle, String member_id, String ebContent) {
		String sql="insert into event_board values (?, ?, ?, SYSDATE, ?, ?)"; // 마지막에 쓰인 글 번호 가져옴
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, ebTitle);
			pstmt.setString(3, member_id);
			pstmt.setString(4, ebContent);
			pstmt.setInt(5, 1); //삭제안된거니 1넣어줌
			return pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류
	}
	
	public ArrayList<EboardDTO> getList(int pageNumber) {
		String sql="select * from (select rownum as rnum, data.* from (select * from event_board where ebAvailable=1 order by ebNum desc)data)where rnum>? and rnum<=?";
	    //String sql = "select*from(select rownum as rnum, data.*from(select*from review_board where review_available = 1 order by review_id desc)data)where rnum>? and rnum<= ?";
		//String sql="select * from bbs where ebNum < ? AND ebAvailable=1 order by desc limit 10"; 
		ArrayList<EboardDTO> list = new ArrayList<EboardDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNumber-1)*10);
	        pstmt.setInt(2, (pageNumber)*10);
			//pstmt.setInt(1, getNext() - (pageNumber-1)*10);
			rs = pstmt.executeQuery();
			while (rs.next()){
				EboardDTO ebdto = new EboardDTO();
				ebdto.setEbNum(rs.getInt("ebNum"));
				ebdto.setEbTitle(rs.getString("ebTitle"));
				ebdto.setMember_id(rs.getString("member_id"));
				ebdto.setEbDate(rs.getString("ebDate"));
				ebdto.setEbContent(rs.getString("ebContent"));
				ebdto.setEbAvailable(rs.getInt("ebAvailable"));
				list.add(ebdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; 
	}
	
	public boolean nextPage(int pageNumber){
		String sql="select * from event_board where ebNum < ? AND ebAvailable=1"; 
		ArrayList<EboardDTO> list = new ArrayList<EboardDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext() - (pageNumber-1)*10);
			rs = pstmt.executeQuery();
			if (rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
	}
	
	public EboardDTO getEboardDTO(int ebNum) {
		String sql="select * from event_board where ebNum =?"; 
		ArrayList<EboardDTO> list = new ArrayList<EboardDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ebNum);
			rs = pstmt.executeQuery();
			if (rs.next()){
				EboardDTO ebdto = new EboardDTO();
				ebdto.setEbNum(rs.getInt("ebNum"));
				ebdto.setEbTitle(rs.getString("ebTitle"));
				ebdto.setMember_id(rs.getString("member_id"));
				ebdto.setEbDate(rs.getString("ebDate"));
				ebdto.setEbContent(rs.getString("ebContent"));
				ebdto.setEbAvailable(rs.getInt("ebAvailable"));
				return ebdto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 		
	}
	
	public int update(int ebNum, String ebTitle, String ebContent) {
		String sql="update event_board set ebTitle=?, ebContent=? where ebNum=?"; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ebTitle);
			pstmt.setString(2, ebContent);
			pstmt.setInt(3, ebNum);
			return pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류
	} 
	
	public int delete(int ebNum) {
		String sql="update event_board set ebAvailable=0 where ebNum=?"; 
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ebNum);
			return pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류
	}
}
