package kosta.rental.loginModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dbclose.util.CloseUtil;
import dbconn.util.ConnectionUtil;

public class RentalDAO { // Controller (Data Access Object)
	private static RentalDAO instance = new RentalDAO();
	public static RentalDAO getInstance() {
		return instance;
	}
	public static Connection getConnection() throws Exception {
		// 연결은 JNDI & Pool 형태로 연결객체 생성해서 리턴 할거임
		Context ctx = new InitialContext();
		Context env = (Context) ctx.lookup("java:comp/env");
		DataSource ds = (DataSource) env.lookup("jdbc:MemberDB");

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
	
	public void insert(RentalDTO dto) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER_LIST(MEMBER_ID, MEMBER_NAME, MEMBER_PWD, MEMBER_PHONE, MEMBER_EMAIL, MEMBER_IMG) VALUES(?,?,?,?,?,?) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMember_id());
			pstmt.setString(2, dto.getMember_name());
			pstmt.setString(3, dto.getMember_pwd());
			pstmt.setString(4, dto.getMember_phone());
			pstmt.setString(5, dto.getMember_email());
			pstmt.setString(6, dto.getMember_img());
			pstmt.executeUpdate(); // pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();		
		}
			CloseUtil.close(conn);
	} // insert() end
	
	public boolean idCheck(String id) throws Exception {
		String sql = "SELECT MEMBER_ID FROM MEMBER_LIST WHERE MEMBER_ID = ? ";
		boolean result = true; //DB에 ID 있음(중복)
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		result = rs.next(); //true:DB에 ID 있음(중복) <-> false:DB에 ID 없음 (사용가능)
	
		CloseUtil.close(rs);
		CloseUtil.close(pstmt);
		return result;
	}// idCheck() end

	public boolean pwCheck(String pwd) throws Exception {
		String pwd_regex = "^(?=.*[a-zA-Z]+)(?=.*[0-9]+).{6,20}$";
		boolean result = pwd.matches(pwd_regex); //
		return result;
	}// emailCheck() end
	
	public boolean phoneCheck(String phone) throws Exception {
		String phone_regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		boolean result = phone.matches(phone_regex); //
		return result;
	}// phoneCheck() end
	
	public boolean emailCheck(String email) throws Exception {
		String email_regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		boolean result = email.matches(email_regex); //
		return result;
	}// emailCheck() end
	
		public int userCheck(String id, String pwd) throws Exception {
		String sql = "SELECT MEMBER_PWD FROM MEMBER_LIST WHERE MEMBER_ID = ? ";
		String dbpwd = "";
		int result = -1;
		
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()){
			dbpwd = rs.getString("MEMBER_PWD");
			if(dbpwd.equals(pwd)) result = 1; //인증성공
			else result = 0; //인증실패(비번틀림)
		} else { 
			result = -1; //해당 아이디 자체가 없음
		} //if end
		CloseUtil.close(rs);
		CloseUtil.close(pstmt);
		CloseUtil.close(conn);
		return result;
	}//userCheck(id,pwd) end

	
	// MY PAGE 에서 수정할 부분 -update
	public RentalDTO getMember(String id) throws Exception {
		String sql = "SELECT * FROM MEMBER_LIST WHERE MEMBER_ID = ? ";
		RentalDTO dto = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			dto = new RentalDTO();
			dto.setMember_id(rs.getString("Member_id"));
			dto.setMember_name(rs.getString("Member_name"));
			dto.setMember_pwd(rs.getString("Member_pwd"));
			dto.setMember_phone(rs.getString("Member_phone"));
			dto.setMember_email(rs.getString("Member_email"));
			dto.setMember_img(rs.getString("Member_img"));
		}
		CloseUtil.close(rs);
		CloseUtil.close(pstmt);
		return dto;
	}
	
	public void modify(RentalDTO dto) throws Exception {
		String sql="UPDATE MEMBER_LIST SET MEMBER_NAME=?, MEMBER_PWD=?, MEMBER_PHONE=?, MEMBER_EMAIL=?, MEMBER_IMG=? WHERE MEMBER_ID=? ";
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getMember_name());
		pstmt.setString(2, dto.getMember_pwd());
		pstmt.setString(3, dto.getMember_phone());
		pstmt.setString(4, dto.getMember_email());
		pstmt.setString(5, dto.getMember_img());
		pstmt.setString(6, dto.getMember_id());
		pstmt.executeUpdate();
		CloseUtil.close(pstmt); CloseUtil.close(conn);
	}//update(dto) end
	
	// MY PAGE 에서 수정할 부분 -delete
	public int delete(String id, String pwd) throws Exception {
		String sql ="SELECT MEMBER_PWD FROM MEMBER_LIST WHERE MEMBER_ID = ?";
		String dbpwd= ""; 
		int result = -1;
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();

		if(rs.next() ) {
			dbpwd = rs.getString("member_pwd");

			if( dbpwd.equals(pwd) ) {
				pstmt = conn.prepareStatement("DELETE FROM MEMBER_LIST WHERE MEMBER_ID = ?");
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				
				result = 1;  //회원 탈퇴 성공
			}else {
				result = 0 ; // 비번 틀림...
			}
		}
		CloseUtil.close(rs);   CloseUtil.close(pstmt);  CloseUtil.close(conn);
		return result;
	} // delete(id, pwd) end	
	
	
}
