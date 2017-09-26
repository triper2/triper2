package event.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

import business.dao.BusinessDAO;
import dbconn.util.ConnectionUtil;

import review.bbs.BbsDAO;

public class EboardDAO {

	private Connection conn;
	private ResultSet rs;
	ServletRequest session;
	HttpServletRequest request;
	
	private static EboardDAO instance = new EboardDAO();

	public static EboardDAO getInstance() {
		return instance;
	}
	public static Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		Context env = (Context) ctx.lookup("java:comp/env");
		DataSource ds = (DataSource) env.lookup("jdbc:TriperDB");

		return ds.getConnection();
	}
	
	public static Connection loadOracleDriver() {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection("oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
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
			conn = loadOracleDriver();
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
	
	public int write(String ebTitle, String ebContent, String member_id) throws Exception {
		String sql="insert into event_board values (?, ?, ?, SYSDATE, ?, ?, ?)"; // 마지막에 쓰인 글 번호 가져옴
		//MultipartRequest multi = FileUtil.createFile(request);
		//String ebImg = multi.getFilesystemName("ebImg");
		try {
			conn = loadOracleDriver();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, ebTitle);
			pstmt.setString(3, member_id);
			pstmt.setString(4, ebContent);
			pstmt.setInt(5, 1); //삭제안된거니 1넣어줌
			pstmt.setString(6, "1");
			return pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류
	}
	
	public ArrayList<EboardDTO> getList(int pageNumber) throws Exception {
		String sql="select * from (select rownum as rnum, data.* from (select * from event_board where ebAvailable=1 order by ebNum desc)data)where rnum>? and rnum<=?";
		//String sql = "select*from(select rownum as rnum, data.*from(select*from review_board where review_available = 1 order by review_id desc)data)where rnum>? and rnum<= ?";
		//String sql="select * from bbs where ebNum < ? AND ebAvailable=1 order by desc limit 10"; 
		ArrayList<EboardDTO> list = new ArrayList<EboardDTO>();
		try {
			conn = loadOracleDriver();
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
				ebdto.setEbImg(rs.getString("ebImg"));
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
			conn = loadOracleDriver();
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
	
	public EboardDTO getEboardDTO(int ebNum) throws Exception {
		EboardDTO ebdto = null;
		String sql="select * from event_board where ebNum =?"; 
		try {
			conn = loadOracleDriver();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ebNum);
			rs = pstmt.executeQuery();
			if (rs.next()){
				ebdto = new EboardDTO();
				ebdto.setEbNum(rs.getInt("ebNum"));
				ebdto.setEbTitle(rs.getString("ebTitle"));
				ebdto.setMember_id(rs.getString("member_id"));
				ebdto.setEbDate(rs.getString("ebDate"));
				ebdto.setEbContent(rs.getString("ebContent"));
				ebdto.setEbAvailable(rs.getInt("ebAvailable"));
				ebdto.setEbImg(rs.getString("ebImg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ebdto; 		
	}
	
	public int update(int ebNum, String ebTitel, String ebContent) throws Exception {
		String sql="update event_board set ebTitle=?, ebContent=?, ebImg=? where ebNum=?"; 
		try {
			conn = loadOracleDriver();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ebTitel);
			pstmt.setString(2, ebContent);
			pstmt.setString(3, "1");
			pstmt.setInt(4, ebNum);
			return pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류
	} 
	
	public int delete(int ebNum) throws Exception {
		String sql="update event_board set ebAvailable=0 where ebNum=?"; 
		try {
			conn = loadOracleDriver();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ebNum);
			return pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //DB 오류
	}
}
