package review.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dbclose.util.CloseUtil;
import dbconn.util.ConnectionUtil;

public class BbsDAO {
	private static BbsDAO instance = new BbsDAO();
	public static BbsDAO getInstance() {
		return instance;
	}
	public static Connection getConnection() throws Exception {
		// 연결은 JNDI & Pool 형태로 연결객체 생성해서 리턴 할거임
		Context ctx = new InitialContext();
		Context env = (Context) ctx.lookup("java:comp/env");
		DataSource ds = (DataSource) env.lookup("jdbc:TriperDB");

		return ds.getConnection();
	}//getConnection() end

	
	public static Connection loadOracleDriver() {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection("oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	} // loadOracleDriver() end


	public int write(String review_Title, String member_ID, String review_Content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into review_board values(seq_review_ID.NEXTVAL,?,?,SYSDATE,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionUtil.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review_Title);
			pstmt.setString(2, member_ID);
			pstmt.setString(3, review_Content);
			pstmt.setInt(4, 1);
			pstmt.setString(5, "1");
			pstmt.setString(6, "1");
			pstmt.setString(7, "1");
			pstmt.setString(8, "1");
			pstmt.setString(9, "1");
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
		}

		return -1;
	}
	public ArrayList<BbsVO> getList(int pageNumber){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from review_board where review_available = 1 order by review_id";
		ArrayList<BbsVO>list = new ArrayList<BbsVO>();
		try{
			conn = ConnectionUtil.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1,rs.getInt(1) -(pageNumber-1)*10);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt(1));
				bbs.setReview_Title(rs.getString(2)); 
				bbs.setMember_ID(rs.getString(3));
				bbs.setReview_Date(rs.getString(4)); 
				bbs.setReview_Content(rs.getString(5));
				bbs.setReview_Available(rs.getInt(6));
				list.add(bbs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from review_board order by setReview_ID aesc";
		ArrayList<BbsVO>list = new ArrayList<BbsVO>();
		try{
			conn = ConnectionUtil.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, rs.getInt(1) - (pageNumber-1)*10);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
		}
		return false;
	}
	
	
	public BbsVO getBbs(int review_ID){//특정한 아이디의 정보를 가져오기 (게시글 보기)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from review_board where review_id = ?";
		try{
			conn = ConnectionUtil.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt(1));
				bbs.setReview_Title(rs.getString(2)); 
				bbs.setMember_ID(rs.getString(3));
				bbs.setReview_Date(rs.getString(4)); 
				bbs.setReview_Content(rs.getString(5));
				bbs.setReview_Available(rs.getInt(6));
				return bbs;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
		}
		return null;
	}
	
	public int update(int review_ID, String review_Title, String review_Content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update review_board set review_Title=?, review_Content= ? where review_ID = ?";
		try {
			conn = ConnectionUtil.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review_Title);
			pstmt.setString(2, review_Content);
			pstmt.setInt(3, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
		}
		return -1;
	}
	public int delete(int review_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update review_board set review_available=0 where review_ID = ?";
		try {
			conn = ConnectionUtil.getConnection("oracle");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
		}
		return -1;
	}

}
