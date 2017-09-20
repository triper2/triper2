package car_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CarDAO {
	
	Connection conn ;
	PreparedStatement pstmt;
	ResultSet rs;
	
	

	
	
	public void getCon(){
		try {
			/*Context initctx =new InitialContext();*/
			Context ctx = new InitialContext();
			Context envctx =(Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc:CarReserveDB");
			//DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc:RentCarDB");
			conn =ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//전체 차량보기
	public Vector<CarListBean> getAllCarlist(){
		//리턴할 vector 객체 선언
		Vector<CarListBean> v = new Vector<CarListBean>();
		CarListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_list";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new CarListBean();
				bean.setProduct_carno(rs.getInt(1));
				bean.setProduct_carname(rs.getString(2));
				bean.setProduct_carcompany(rs.getString(3));
				bean.setProduct_carprice(rs.getInt(4));
				bean.setProduct_carusepeople(rs.getInt(5));
				bean.setProduct_carinfo(rs.getString(6));
				bean.setProduct_carimg(rs.getString(7));
				bean.setProduct_carcategory(rs.getString(8));
				v.add(bean);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return v;
	}

	
		//category 별 데이터 베이스
	public Vector<CarListBean> getCategoryCarList(String carcategory) {
		
		//리턴할 vector 객체 선언
				Vector<CarListBean> v = new Vector<CarListBean>();
				CarListBean bean = null;
				
				try {
					getCon();
					String sql = "select * from product_list where product_carcategory=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, carcategory);
					rs = pstmt.executeQuery();
					
					while(rs.next()){
						bean = new CarListBean();
						bean.setProduct_carno(rs.getInt(1));
						bean.setProduct_carname(rs.getString(2));
						bean.setProduct_carcompany(rs.getString(3));
						bean.setProduct_carprice(rs.getInt(4));
						bean.setProduct_carusepeople(rs.getInt(5));
						bean.setProduct_carinfo(rs.getString(6));
						bean.setProduct_carimg(rs.getString(7));
						bean.setProduct_carcategory(rs.getString(8));
						v.add(bean);
					}
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return v;
	}

	
	//하나의 자동차 정보 리턴
	public CarListBean getOneCar(int carno) {
		CarListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_list where product_carno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, carno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new CarListBean();
				bean.setProduct_carno(rs.getInt(1));
				bean.setProduct_carname(rs.getString(2));
				bean.setProduct_carcompany(rs.getString(3));
				bean.setProduct_carprice(rs.getInt(4));
				bean.setProduct_carusepeople(rs.getInt(5));
				bean.setProduct_carinfo(rs.getString(6));
				bean.setProduct_carimg(rs.getString(7));
				bean.setProduct_carcategory(rs.getString(8));
			
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	//주문현황 저장하는 메소드
	public void insertCarOrder(CarOrderBean cbean){
		try {
			getCon();
			//쿼리
			String sql = "insert into reserved_list values(order_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			//실행할 객체 선언
			pstmt=conn.prepareStatement(sql);
			//? 값 대입
			pstmt.setInt(1, cbean.getProduct_carno());
			pstmt.setInt(2, cbean.getReserved_product_count());
			pstmt.setString(3, cbean.getReserved_carbegindate());
			pstmt.setString(4, cbean.getReserved_carenddate());
			pstmt.setInt(5, cbean.getReserved_option_usein());
			pstmt.setInt(6, cbean.getReserved_option_carwifi());
			pstmt.setInt(7, cbean.getReserved_option_carnavi());
			pstmt.setInt(8, cbean.getReserved_option_carbabyseat());
			pstmt.setString(9, cbean.getMemberphone());
			pstmt.setString(10, cbean.getMemberpass());
			pstmt.setInt(11, cbean.getTotalprice());
			pstmt.setInt(12,cbean.getCalDateDays());
			pstmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//해당 전화번호와 패스워드로 예약한 주문정보를 모두 가져온다
	public Vector<CarConfirmBean> getAllCarOrder(String memberphone, String memberpass){
		
		//return 타입
		Vector<CarConfirmBean> v =new Vector<CarConfirmBean>();
		
		CarConfirmBean bean = null;
		
		try {
			
			getCon();
			String sql ="select * from product_list natural join reserved_list where "
					+ "sysdate < to_date(reserved_carbegindate , 'YYYY-MM-DD') "
					+ "and memberphone=? and memberpass=?";
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberphone);
			pstmt.setString(2, memberpass);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				bean = new CarConfirmBean();
				bean.setOrderid(rs.getInt(9));
				bean.setReserved_product_count(rs.getInt(10));
				bean.setReserved_carbegindate(rs.getString(11));
				bean.setReserved_option_usein(rs.getInt(13));
				bean.setReserved_option_carwifi(rs.getInt(14));
				bean.setReserved_option_carnavi(rs.getInt(15));
				bean.setReserved_option_carseat(rs.getInt(16));
				bean.setProduct_carname(rs.getString(2));
				bean.setProduct_carprice(rs.getInt(4));
				bean.setProduct_carimg(rs.getString(7));
				bean.setTotalprice(rs.getInt(19));
				bean.setCalDateDays(rs.getInt(20));
				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public CarConfirmBean getOnOrder(int orderid) {
		
		//리턴 타입선언
		CarConfirmBean cbean = null;
		try {
			getCon();
			String sql = "select * from reserved_list where orderid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				cbean = new CarConfirmBean();
				cbean.setOrderid(orderid);
				cbean.setReserved_carbegindate(rs.getString(4));
				cbean.setReserved_option_usein(rs.getInt(6));
				cbean.setReserved_option_carwifi(rs.getInt(7));
				cbean.setReserved_option_carnavi(rs.getInt(8));
				cbean.setReserved_option_carseat(rs.getInt(9));
				
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cbean;
	}

	
	//하나의 주문 정보를 삭제하는 메소드
	public int CarOrderDelete(int orderid, String memberpass) {
		int result=0;
		try {
			getCon();
			
			String sql ="delete from reserved_list  where orderid=? and memberpass=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값을 대입
			pstmt.setInt(1, orderid);
			pstmt.setString(2, memberpass);
			//쿼리가 실행되지 않았다면 0값이 리턴 실행이 되면 1이 리턴됩니다.
			result = pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;
	}

	public void CarOrderUpdate(CarOrderBean bean) {
		try {
			getCon();
			String sql = "update reserved_list set reserved_carbegindate =?,reserved_product_count =?,reserved_option_usein =?,"
					+ "reserved_option_carwifi =?,reserved_option_carseat =? where orderid=? and memberpass=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getReserved_carbegindate());
			pstmt.setInt(2, bean.getReserved_product_count());
			pstmt.setInt(3,bean.getReserved_option_usein());
			pstmt.setInt(4,bean.getReserved_option_carwifi());
			pstmt.setInt(5,bean.getReserved_option_carbabyseat());
			pstmt.setInt(6,bean.getOrderid());
			pstmt.setString(7, bean.getMemberpass());
			pstmt.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void insertCarAdd(CarListBean cbean) {
		try {
			
			getCon();
			String sql="insert into product_list values(?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, cbean.getProduct_carno());
			pstmt.setString(2, cbean.getProduct_carname());
			pstmt.setString(3, cbean.getProduct_carcompany());
			pstmt.setInt(4, cbean.getProduct_carprice());
			pstmt.setInt(5,cbean.getProduct_carusepeople());
			pstmt.setString(6, cbean.getProduct_carinfo());
			pstmt.setString(7, cbean.getProduct_carimg());
			pstmt.setString(8, cbean.getProduct_carcategory());
			
			pstmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
