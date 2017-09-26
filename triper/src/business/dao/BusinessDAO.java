package business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import business.vo.BusinessVO;
import dbconn.util.ConnectionUtil;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class BusinessDAO {

	private static BusinessDAO instance = new BusinessDAO();
	public static BusinessDAO getInstance() {
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
	public void addBusiness(BusinessVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into business_list"
						+ "(business_id, business_name, business_road_address, business_address,"
						+ " business_tel, business_x, business_y, business_category, "
						+ " BUSINESS_ASSENT, BUSINESS_DELETE, member_id)"
						+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBusiness_id());
			pstmt.setString(2, vo.getBusiness_name());
			pstmt.setString(3, vo.getBusiness_road_address());
			pstmt.setString(4, vo.getBusiness_address());
			pstmt.setString(5, vo.getBusiness_tel());
			pstmt.setString(6, vo.getBusiness_x());
			pstmt.setString(7, vo.getBusiness_y());
			pstmt.setString(8, vo.getBusiness_category());
			pstmt.setString(9, vo.getBusiness_assent());
			pstmt.setString(10, vo.getBusiness_delete());
			pstmt.setString(11, vo.getMember_id());
			pstmt.executeUpdate();
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
	}
	
	public ArrayList<BusinessVO> myBusinessList(String member_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from business_list where member_id=?";
		ArrayList<BusinessVO> list = new ArrayList<BusinessVO>();
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BusinessVO businessVO = new BusinessVO();
				businessVO.setBusiness_id(rs.getString("business_id"));
				businessVO.setBusiness_name(rs.getString("business_name"));
				businessVO.setBusiness_road_address(rs.getString("business_road_address"));
				businessVO.setBusiness_address(rs.getString("business_address"));
				businessVO.setBusiness_tel(rs.getString("business_tel"));
				businessVO.setBusiness_x(rs.getString("business_x"));
				businessVO.setBusiness_y(rs.getString("business_y"));
				businessVO.setBusiness_category(rs.getString("business_category"));
				businessVO.setBusiness_assent(rs.getString("BUSINESS_ASSENT"));
				businessVO.setBusiness_delete(rs.getString("BUSINESS_DELETE"));
				businessVO.setMember_id(rs.getString("member_id"));
	            list.add(businessVO);
	         }
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
	    return list;
	}
	public ArrayList<BusinessVO> allBusinessList(String keyword, String category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from business_list where BUSINESS_ASSENT='승인' "
				+ " and business_category='"+category+"' and (";
		
		String[] kwd = keyword.split(" ");
		int kwdLength = kwd.length;
		ArrayList<String> arr = new ArrayList<String>();
		boolean first = true;
		for(int i=0; i<kwdLength; i++) {
			if(kwd[i] != "") {
				if(!first) {
					sql += " or ";
				}
				first = false;
				sql += " business_road_address LIKE '%"+kwd[i]+"%'"
					+ " or business_address LIKE '%"+kwd[i]+"%'"
					+ " or business_name LIKE '%"+kwd[i]+"%'";
			}
		}
		sql += ")";
		
		ArrayList<BusinessVO> list = new ArrayList<BusinessVO>();
		try {
			conn = loadOracleDriver();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BusinessVO businessVO = new BusinessVO();
				businessVO.setBusiness_id(rs.getString("business_id"));
				businessVO.setBusiness_name(rs.getString("business_name"));
				businessVO.setBusiness_road_address(rs.getString("business_road_address"));
				businessVO.setBusiness_address(rs.getString("business_address"));
				businessVO.setBusiness_tel(rs.getString("business_tel"));
				businessVO.setBusiness_x(rs.getString("business_x"));
				businessVO.setBusiness_y(rs.getString("business_y"));
				businessVO.setBusiness_category(rs.getString("business_category"));
				businessVO.setBusiness_assent(rs.getString("BUSINESS_ASSENT"));
				businessVO.setBusiness_delete(rs.getString("BUSINESS_DELETE"));
				businessVO.setMember_id(rs.getString("member_id"));
	            list.add(businessVO);
	         }
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
	    return list;
	}
}