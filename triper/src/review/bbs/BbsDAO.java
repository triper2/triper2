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
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, review_Title);
		pstmt.setString(2, member_ID);
		pstmt.setString(3, review_Content);
		pstmt.setInt(4, 1);
		String test = review_Content.substring(review_Content.indexOf("<img src=")+10);
		System.out.println(test);
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

public int commentWrite(int review_ID, String member_ID, String review_comment_content) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "insert into review_comment values(seq_review_comment_id.NEXTVAL,?,?,SYSDATE,?,?,?)";
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, review_ID);
		pstmt.setString(2, member_ID);
		pstmt.setString(3, review_comment_content);
		pstmt.setInt(4, 1);
		pstmt.setString(5, "1");
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

public ArrayList<BbsVO> getComment(int review_ID){
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select*from review_comment where review_comment_available = 1 and review_ID = ? order by review_comment_id";

	ArrayList<BbsVO>list1 = new ArrayList<BbsVO>();
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,review_ID);
		rs = pstmt.executeQuery();
		while(rs.next()){
			BbsVO bbs = new BbsVO();
			bbs.setReview_comment_id(rs.getInt(1));
			bbs.setReview_ID(rs.getInt(2));
			bbs.setMember_ID(rs.getString(3));
			bbs.setReview_comment_date(rs.getString(4));
			bbs.setReview_comment_content(rs.getString(5).replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;")
					.replaceAll("\n", "<br>"));
			bbs.setReview_comment_available(rs.getInt(6));
			bbs.setMember_image(rs.getString(7));
			list1.add(bbs);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return list1;
}

   public int pageingCount() {
	   Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	      String sql = "select count(*) from review_board where review_available = 1";
	      int pageCount = 0;
	      try{
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         if(rs.next()){
	        	 
	            pageCount=((rs.getInt(1))/6+1);
	            
	         }
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      return pageCount;
	   }
   
   public ArrayList<BbsVO> getAllList(){
	   Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	      String sql = "select*from review_board where review_available = 1 order by review_id desc";
	      ArrayList<BbsVO>list = new ArrayList<BbsVO>();
	      try{
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         while(rs.next()){
	            BbsVO bbs = new BbsVO();
	            bbs.setReview_ID(rs.getInt(1));
	            bbs.setReview_Title(rs.getString(2).replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;")
	                  .replaceAll("\n", "<br>")); 
	            bbs.setMember_ID(rs.getString(3));
	            bbs.setReview_Date(rs.getString(4)); 
	            bbs.setReview_Content(rs.getString(5));
	            bbs.setReview_Available(rs.getInt(6));
	            list.add(bbs);
	         }
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      return list;
	   }

	   
	   
	   public ArrayList<BbsVO> getList(int pageNumber){
		   Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
	      String sql = "select*from(select rownum as rnum, data.*from(select*from review_board where review_available = 1 order by review_id desc)data)where rnum>? and rnum<= ?";
	      ArrayList<BbsVO>list = new ArrayList<BbsVO>();
	      try{
	         pstmt = conn.prepareStatement(sql);
	         //pstmt.setInt(1, (review_ID+1) - pageNumber);
	         pstmt.setInt(1, (pageNumber-1)*6);
	         pstmt.setInt(2, (pageNumber)*6);
	         rs = pstmt.executeQuery();
	         while(rs.next()){
	            BbsVO bbs = new BbsVO();
	            bbs.setReview_ID(rs.getInt("review_ID"));
	            bbs.setReview_Title(rs.getString("review_Title").replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;")
	                  .replaceAll("\n", "<br>")); 
	            bbs.setMember_ID(rs.getString("member_ID"));
	            bbs.setReview_Date(rs.getString("review_Date")); 
	            bbs.setReview_Content(rs.getString("review_Content"));
	            bbs.setReview_Available(rs.getInt("review_Available"));
	            list.add(bbs);
	         }
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	      return list;
	   }
	   
	   public boolean nextPage(int pageNumber,int review_ID){//페이징처리함수
		   Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		   String sql = "select*from review_board where review_id < ? and review_available = 1";
	      
	      try{
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, (review_ID+1) - (pageNumber-1) * 6);
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
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select*from review_board where review_id = ?";
	try{
		 pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, review_ID);
		rs = pstmt.executeQuery();
		if(rs.next()){
			BbsVO bbs = new BbsVO();
			bbs.setReview_ID(rs.getInt(1));
			bbs.setReview_Title(rs.getString(2).replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;")
					.replaceAll("\n", "<br>")); 
			bbs.setMember_ID(rs.getString(3));
			bbs.setReview_Date(rs.getString(4)); 
			bbs.setReview_Content(rs.getString(5));
			bbs.setReview_Available(rs.getInt(6));
			return bbs;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
}

public int update(int review_ID, String review_Title, String review_Content) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "update review_board set review_Title=?, review_Content= ? where review_ID = ?";
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
	Connection conn = null;
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
