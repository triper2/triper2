package review.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
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
	}// getConnection() end

	public static Connection loadOracleDriver() {
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection("oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	} // loadOracleDriver() end

	public int write(String review_Title, String member_ID, String review_Content, String review_Image_1,
			String member_Image) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into review_board values(seq_review_ID.NEXTVAL,?,?,SYSDATE,?,?,?,?,?,?,?)";
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review_Title);
			pstmt.setString(2, member_ID);
			pstmt.setString(3, review_Content);
			pstmt.setInt(4, 1);
			pstmt.setString(5, review_Image_1);
			pstmt.setString(6, member_Image);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
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

	public int commentWrite(int review_ID, String member_ID, String review_comment_content, String member_Image) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into review_comment values(seq_review_comment_id.NEXTVAL,?,?,SYSDATE,?,?,?)";
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			pstmt.setString(2, member_ID);
			pstmt.setString(3, review_comment_content);
			pstmt.setInt(4, 1);
			pstmt.setString(5, member_Image);
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

	public ArrayList<BbsVO> getComment(int review_ID, int commentPageNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from(select rownum as rnum, data.*from(select*from review_comment where review_comment_available = 1 and review_ID = ? order by review_comment_id desc)data)where rnum>? and rnum<= ?";

		ArrayList<BbsVO> list1 = new ArrayList<BbsVO>();
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			pstmt.setInt(2, (commentPageNumber - 1) * 10);
			pstmt.setInt(3, (commentPageNumber) * 10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsVO bbs = new BbsVO();
				bbs.setReview_comment_id(rs.getInt("review_comment_id"));
				bbs.setReview_ID(rs.getInt("review_ID"));
				bbs.setMember_ID(rs.getString("member_ID"));
				bbs.setReview_comment_date(rs.getString("review_comment_date"));
				bbs.setReview_comment_content(rs.getString("review_comment_content").replaceAll(" ", "&nbsp;")
						.replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				bbs.setReview_comment_available(rs.getInt("review_comment_available"));
				bbs.setMember_image(rs.getString("member_image"));
				list1.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	public int commentPageingCount(int review_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from review_comment where review_comment_available = 1 and review_ID = ?";
		int commentPageingCount = 0;
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) % 10 == 0) {
					commentPageingCount = ((rs.getInt(1)) / 10);
				} else {
					commentPageingCount = ((rs.getInt(1)) / 10 + 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentPageingCount;
	}

	public int commentCount(int review_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from review_comment where review_comment_available = 1 and review_ID = ?";
		int commentCount = 0;
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				commentCount = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentCount;
	}

	public int pageingCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from review_board where review_available = 1";
		int pageCount = 0;
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) % 6 == 0) {
					pageCount = ((rs.getInt(1)) / 6);
				} else {
					pageCount = ((rs.getInt(1)) / 6 + 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageCount;
	}
	public int pageingCount(String review_Title) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from review_board where review_Title like ? and review_available = 1";
		int pageCount = 0;
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+review_Title+"%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) % 6 == 0) {
					pageCount = ((rs.getInt(1)) / 6);
				} else {
					pageCount = ((rs.getInt(1)) / 6 + 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageCount;
	}

	public ArrayList<BbsVO> getAllList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from review_board where review_available = 1 order by review_id desc";
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt(1));
				bbs.setReview_Title(
						rs.getString(2).replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				bbs.setMember_ID(rs.getString(3));
				bbs.setReview_Date(rs.getString(4));
				bbs.setReview_Content(rs.getString(5));
				bbs.setReview_Available(rs.getInt(6));
				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BbsVO> getList(int pageNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from(select rownum as rnum, data.*from(select*from review_board where review_available = 1 order by review_id desc)data)where rnum>? and rnum<= ?";
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, (review_ID+1) - pageNumber);
			pstmt.setInt(1, (pageNumber - 1) * 6);
			pstmt.setInt(2, (pageNumber) * 6);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt("review_ID"));
				bbs.setReview_Title(rs.getString("review_Title").replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;")
						.replaceAll("\n", "<br>"));
				bbs.setMember_ID(rs.getString("member_ID"));
				bbs.setReview_Date(rs.getString("review_Date"));
				bbs.setReview_Content(rs.getString("review_Content"));
				bbs.setReview_Available(rs.getInt("review_Available"));
				bbs.setReview_Image_1(rs.getString("review_Image_1"));
				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<BbsVO> getList(int pageNumber, String review_Title) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from(select rownum as rnum, data.*from(select*from review_board where review_Title like ? and review_available = 1 order by review_id desc)data)where rnum>? and rnum<= ?";
		ArrayList<BbsVO> list = new ArrayList<BbsVO>();
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+review_Title+"%");
			pstmt.setInt(2, (pageNumber - 1) * 6);
			pstmt.setInt(3, (pageNumber) * 6);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt("review_ID"));
				bbs.setReview_Title(rs.getString("review_Title").replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;")
						.replaceAll("\n", "<br>"));
				bbs.setMember_ID(rs.getString("member_ID"));
				bbs.setReview_Date(rs.getString("review_Date"));
				bbs.setReview_Content(rs.getString("review_Content"));
				bbs.setReview_Available(rs.getInt("review_Available"));
				bbs.setReview_Image_1(rs.getString("review_Image_1"));
				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public BbsVO getBbs(int review_ID) {// 특정한 아이디의 정보를 가져오기 (게시글 보기)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from review_board where review_id = ?";
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				BbsVO bbs = new BbsVO();
				bbs.setReview_ID(rs.getInt("review_ID"));
				bbs.setReview_Title(rs.getString("review_Title").replaceAll(" ", "&nbsp;").replaceAll(">", "&gt;")
						.replaceAll("\n", "<br>"));
				bbs.setMember_ID(rs.getString("member_ID"));
				bbs.setReview_Date(rs.getString("review_Date"));
				bbs.setReview_Content(rs.getString("review_Content"));
				bbs.setReview_Available(rs.getInt("review_Available"));
				bbs.setMember_image(rs.getString("review_Image_2"));
				bbs.setReview_Like(rs.getInt("review_Like"));
				bbs.setReview_Hate(rs.getInt("review_Hate"));
				bbs.setReview_Viewcount(rs.getInt("review_Viewcount"));
				return bbs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int update(int review_ID, String review_Title, String review_Content, String review_Image_1) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update review_board set review_Title= ?, review_Content= ?,review_Image_1= ? where review_ID = ?";

		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review_Title);
			pstmt.setString(2, review_Content);
			pstmt.setString(3, review_Image_1);
			pstmt.setInt(4, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int likeUpdate(int review_Like, int review_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update review_board set review_Like= ? where review_ID = ?";

		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_Like + 1);
			pstmt.setInt(2, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int hateUpdate(int review_Hate, int review_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update review_board set review_Hate= ? where review_ID = ?";

		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_Hate - 1);
			pstmt.setInt(2, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int viewcountUpdate(int review_Viewcount, int review_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update review_board set review_Viewcount= ? where review_ID = ?";

		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_Viewcount + 1);
			pstmt.setInt(2, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(int review_ID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update review_board set review_available=0 where review_ID = ?";
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_ID);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int commentdelete(int review_comment_id) {
		System.out.println(review_comment_id);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update REVIEW_COMMENT set review_comment_available=0 where review_comment_id = ?";
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_comment_id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
