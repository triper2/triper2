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
			DataSource ds = (DataSource) envctx.lookup("jdbc:TriperDB");
			//DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc:RentCarDB");
			conn =ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ü ��������
	public Vector<CarListBean> getAllCarlist(String business_id){
		//������ vector ��ü ����
		Vector<CarListBean> v = new Vector<CarListBean>();
		CarListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_list where business_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, business_id);
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

	
		//category �� ������ ���̽�
	public Vector<CarListBean> getCategoryCarList(String carcategory, String business_id) {
		
		//������ vector ��ü ����
				Vector<CarListBean> v = new Vector<CarListBean>();
				CarListBean bean = null;
				
				try {
					getCon();
					String sql = "select * from product_list where product_carcategory=? and business_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, carcategory);
					pstmt.setString(2, business_id);
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

	
	//�ϳ��� �ڵ��� ���� ����
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
	
	//�ֹ���Ȳ �����ϴ� �޼ҵ�
	public void insertCarOrder(CarOrderBean cbean){
		try {
			getCon();
			//����
			String sql = "insert into reserved_list values(order_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			//������ ��ü ����
			pstmt=conn.prepareStatement(sql);
			//? �� ����
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
			pstmt.setString(13, cbean.getBusiness_id());
			pstmt.setString(14, cbean.getMember_id());
			pstmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�ش� ��ȭ��ȣ�� �н������ ������ �ֹ������� ��� �����´�
	public Vector<CarConfirmBean> getAllCarOrder(String member_id){
		
		//return Ÿ��
		Vector<CarConfirmBean> v =new Vector<CarConfirmBean>();
		
		CarConfirmBean bean = null;
		
		try {
			
			getCon();
			String sql ="select * from product_list natural join reserved_list where "
					+ "sysdate < to_date(reserved_carbegindate , 'YYYY-MM-DD') "
					+ "and member_id=?";
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("asd");
				bean = new CarConfirmBean();
				bean.setOrderid(rs.getInt("orderid"));
				bean.setReserved_product_count(rs.getInt("Reserved_product_count"));
				bean.setReserved_carbegindate(rs.getString("Reserved_carbegindate"));
				bean.setReserved_carenddate(rs.getString("Reserved_carenddate"));
				bean.setReserved_option_usein(rs.getInt("Reserved_option_usein"));
				bean.setReserved_option_carwifi(rs.getInt("Reserved_option_carwifi"));
				bean.setReserved_option_carnavi(rs.getInt("Reserved_option_carnavi"));
				bean.setReserved_option_carseat(rs.getInt("Reserved_option_carseat"));
				bean.setProduct_carname(rs.getString("Product_carname"));
				bean.setProduct_carprice(rs.getInt("Product_carprice"));
				bean.setProduct_carimg(rs.getString("Product_carimg"));
				bean.setTotalprice(rs.getInt("Totalprice"));
				bean.setCalDateDays(rs.getInt("CalDateDays"));
				v.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public CarConfirmBean getOnOrder(int orderid) {
		
		//���� Ÿ�Լ���
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

	
	//�ϳ��� �ֹ� ������ �����ϴ� �޼ҵ�
	public int CarOrderDelete(int orderid, String memberpass) {
		int result=0;
		try {
			getCon();
			
			String sql ="delete from reserved_list  where orderid=? and memberpass=?";
			pstmt = conn.prepareStatement(sql);
			//?�� ���� ����
			pstmt.setInt(1, orderid);
			pstmt.setString(2, memberpass);
			//������ ������� �ʾҴٸ� 0���� ���� ������ �Ǹ� 1�� ���ϵ˴ϴ�.
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
			String sql = "update reserved_list set reserved_carbegindate =?,reserved_carenddate=?,reserved_product_count =?,reserved_option_usein =?,"
					+ "reserved_option_carwifi =?,reserved_option_carseat =?,totalprice=?,caldatedays=? where orderid=? and memberpass=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getReserved_carbegindate());
			pstmt.setString(2, bean.getReserved_carenddate());
			pstmt.setInt(3, bean.getReserved_product_count());
			pstmt.setInt(4,bean.getReserved_option_usein());
			pstmt.setInt(5,bean.getReserved_option_carwifi());
			pstmt.setInt(6,bean.getReserved_option_carbabyseat());
			pstmt.setInt(7, bean.getTotalprice());
			pstmt.setInt(8, bean.getCalDateDays());
			pstmt.setInt(9,bean.getOrderid());
			pstmt.setString(10, bean.getMemberpass());
			pstmt.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void insertCarAdd(CarListBean cbean) {
		try {
			
			getCon();
			String sql="insert into product_list(Product_carno,"
					+ "Product_carname,"
					+ "Product_carcompany,"
					+ "Product_carprice,"
					+ "Product_carusepeople,"
					+ "Product_carinfo,"
					+ "Product_carimg,"
					+ "Product_carcategory,"
					+ "Business_id) values(?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, cbean.getProduct_carno());
			pstmt.setString(2, cbean.getProduct_carname());
			pstmt.setString(3, cbean.getProduct_carcompany());
			pstmt.setInt(4, cbean.getProduct_carprice());
			pstmt.setInt(5,cbean.getProduct_carusepeople());
			pstmt.setString(6, cbean.getProduct_carinfo());
			pstmt.setString(7, cbean.getProduct_carimg());
			pstmt.setString(8, cbean.getProduct_carcategory());
			pstmt.setString(9, cbean.getBusiness_id());
			
			pstmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public CarConfirmBean getOneprice(String carimg) {
		CarConfirmBean cpbean =null;
		try {
			getCon();
			String sql = "select * from product_list where product_carimg=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, carimg);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cpbean = new CarConfirmBean();
				cpbean.setProduct_carimg(carimg);
				cpbean.setProduct_carprice(rs.getInt(4));
			}
			conn.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cpbean;
	}
}
