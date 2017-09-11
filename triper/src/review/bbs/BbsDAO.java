package review.bbs;

import java.sql.*;
import java.util.ArrayList;

public class BbsDAO {

	private Connection conn;
	private ResultSet rs;

	public BbsDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "dan";
			String dbPassword = "1004";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public int write(String review_Title, String member_ID, String review_Content) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into review_board values(seq_review_ID.NEXTVAL,?,?,SYSDATE,?,?,?,?,?,?,?)";
		try {
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
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return -1;
	}
	public ArrayList<BbsVO> getList(int pageNumber){
		String sql = "select*from review_board where review_available = 1 order by review_id";
		ArrayList<BbsVO>list = new ArrayList<BbsVO>();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1,rs.getInt(1) -(pageNumber-1)*10);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt(1));
				bbs.setReview_Title(rs.getString(2)); 
				bbs.setMember_ID(rs.getString(3));
				bbs.setReview_Date(rs.getString(4)); 
				bbs.setReview_Content(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber){
		String sql = "select*from review_board order by setReview_ID aesc";
		ArrayList<BbsVO>list = new ArrayList<BbsVO>();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, rs.getInt(1) - (pageNumber-1)*10);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public BbsVO getBbs(int review_ID){//특정한 아이디의 정보를 가져오기 (게시글 보기)
		String sql = "select*from review_board where review_id = ?";
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt(1));
				bbs.setReview_Title(rs.getString(2)); 
				bbs.setMember_ID(rs.getString(3));
				bbs.setReview_Date(rs.getString(4)); 
				bbs.setReview_Content(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int review_ID, String review_Title, String review_Content) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update review_board set review_Title=? review_Content= ? where review_ID = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review_Title);
			pstmt.setString(2, review_Content);
			pstmt.setInt(3, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -1;
	}
	public int delete(int review_ID) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update review_board set review_available=0 where review_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -1;
	}

}
