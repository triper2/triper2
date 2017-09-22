package ski_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import ski_controller.SkiOrder;

public class SkiDAO {
	
	Connection conn ;
	PreparedStatement pstmt;
	ResultSet rs;
	
	

	
	
	public void getCon(){
		try {
			/*Context initctx =new InitialContext();*/
			Context ctx = new InitialContext();
			Context envctx =(Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc:SkiReserveDB");
			//DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc:RentCarDB");
			conn =ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}





	public Vector<SkiListBean> getAllSkilist() {
		
		//리턴할 vector 객체 선언
				Vector<SkiListBean> v = new Vector<SkiListBean>();
				SkiListBean bean = null;
				
				try {
					getCon();
					String sql = "select * from product_ski_list";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()){
						bean = new SkiListBean();
						bean.setProduct_skino(rs.getInt(1));
						bean.setProduct_skiname(rs.getString(2));
						bean.setProduct_skiprice(rs.getInt(3));
						bean.setProduct_skiinfo(rs.getString(4));
						bean.setProduct_skiimg(rs.getString(5));
						
						
						v.add(bean);
					}
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return v;
	}





	public Vector<SkiClothListBean> getAllSkiclothlist() {
		//리턴할 vector 객체 선언
		Vector<SkiClothListBean> v = new Vector<SkiClothListBean>();
		SkiClothListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_skicloth_list";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				bean = new SkiClothListBean();
			
				bean.setProduct_skiclothno(rs.getInt(1));
				bean.setProduct_skiclothname(rs.getString(2));
				bean.setProduct_skiclothprice(rs.getInt(3));
				bean.setProduct_skiclothinfo(rs.getString(4));
				bean.setProduct_skiclothimg(rs.getString(5));
				v.add(bean);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}





	public SkiListBean getOneski(int skino) {
	
		SkiListBean bean = null;
			
			try {
				getCon();
				String sql = "select * from product_ski_list where product_skino=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, skino);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					bean = new SkiListBean();
					bean.setProduct_skino(rs.getInt(1));
					bean.setProduct_skiname(rs.getString(2));
				
					bean.setProduct_skiprice(rs.getInt(3));
					
					bean.setProduct_skiinfo(rs.getString(4));
					bean.setProduct_skiimg(rs.getString(5));
					
				
				}
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}





	public SkiClothListBean getOneSkicloth(int skiclothno) {
		SkiClothListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_skicloth_list where product_skiclothno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, skiclothno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new SkiClothListBean();
				bean.setProduct_skiclothno(rs.getInt(1));
				bean.setProduct_skiclothname(rs.getString(2));
			
				bean.setProduct_skiclothprice(rs.getInt(3));
				
				bean.setProduct_skiclothinfo(rs.getString(4));
				bean.setProduct_skiclothimg(rs.getString(5));
				
			
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}





	public void insertSkiOrder(Skiorder1 bean) {
		try {
			getCon();
			//쿼리
			String sql = "insert into reserve_ski values(s_orderid_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			
			
			//실행할 객체 선언
			pstmt=conn.prepareStatement(sql);
			//? 값 대입
			pstmt.setString(1, bean.getSkibeginday());
			pstmt.setString(2, bean.getSkiendday());
			pstmt.setString(3, bean.getSkisize());
			pstmt.setInt(4, bean.getProduct_skino());
			pstmt.setString(5, bean.getProduct_skiname());
			pstmt.setInt(6, bean.getProduct_skiprice());
			pstmt.setString(7, bean.getProduct_skiimg());
			pstmt.setString(8, bean.getMemberphone());
			pstmt.setString(9, bean.getMemberpass());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}





	public void insertskiclothOrder(SkiClothOrder bean) {
		try {
			getCon();
			//쿼리
			String sql = "insert into reserve_skicloth values(sc_orderid_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			
			
			//실행할 객체 선언
			pstmt=conn.prepareStatement(sql);
			//? 값 대입
			pstmt.setString(1, bean.getSkiclothbeginday());
			pstmt.setString(2, bean.getSkiclothendday());
			pstmt.setString(3, bean.getSkiclothsize());
			pstmt.setInt(4, bean.getProduct_skiclothno());
			pstmt.setString(5, bean.getProduct_skiclothname());
			pstmt.setInt(6, bean.getProduct_skiclothprice());
			pstmt.setString(7, bean.getProduct_skiclothimg());
			pstmt.setString(8, bean.getMemberphone());
			pstmt.setString(9, bean.getMemberpass());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}





	public Vector<Skiorder1> getAllSkiOrder(String memberphone, String memberpass) {
		//return 타입
		Vector<Skiorder1> sv =new Vector<Skiorder1>();
		
		Skiorder1 sbean = null;
		
		try {
			
			getCon();
			String sql ="select * from reserve_ski where "
					+ "sysdate < to_date(skibeginday , 'YYYY-MM-DD') "
					+ "and memberphone=? and memberpass=?";
			
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberphone);
			pstmt.setString(2, memberpass);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				sbean = new Skiorder1();
				sbean.setS_orderid(rs.getInt(1));
				sbean.setSkibeginday(rs.getString(2));
				sbean.setSkiendday(rs.getString(3));
				sbean.setSkisize(rs.getString(4));
				sbean.setProduct_skiname(rs.getString(6));
				sbean.setProduct_skiprice(rs.getInt(7));
				sbean.setProduct_skiimg(rs.getString(8));
				sv.add(sbean);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sv;

	}





	public Vector<SkiClothOrder> getAllSkiClothOrder(String memberphone, String memberpass) {
	
		//return 타입
		Vector<SkiClothOrder> scv =new Vector<SkiClothOrder>();
		
		SkiClothOrder scbean = null;
		
		try {
			
			getCon();
			String sql ="select * from reserve_skicloth where "
					+ "sysdate < to_date(skiclothbeginday , 'YYYY-MM-DD') "
					+ "and memberphone=? and memberpass=?";
			
					
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberphone);
			pstmt.setString(2, memberpass);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				scbean = new SkiClothOrder();
				scbean.setSc_orderid(rs.getInt(1));
				scbean.setSkiclothbeginday(rs.getString(2));
				scbean.setSkiclothendday(rs.getString(3));
				scbean.setSkiclothsize(rs.getString(4));
				scbean.setProduct_skiclothname(rs.getString(6));
				scbean.setProduct_skiclothprice(rs.getInt(7));
				scbean.setProduct_skiclothimg(rs.getString(8));
				scv.add(scbean);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scv;

	}





	public int SkiOrderDelete(int s_orderid, String memberpass) {
		int result=0;
		try {
			getCon();
			
			String sql ="delete from reserve_ski  where s_orderid=? and memberpass=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값을 대입
			pstmt.setInt(1, s_orderid);
			pstmt.setString(2, memberpass);
			//쿼리가 실행되지 않았다면 0값이 리턴 실행이 되면 1이 리턴됩니다.
			result = pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;

	}





	public int Skiclothdelete(int sc_orderid, String memberpass) {
		int result1=0;
		try {
			getCon();
			
			String sql ="delete from reserve_skicloth where sc_orderid=? and memberpass=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값을 대입
			pstmt.setInt(1, sc_orderid);
			pstmt.setString(2, memberpass);
			//쿼리가 실행되지 않았다면 0값이 리턴 실행이 되면 1이 리턴됩니다.
			result1 = pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result1;

	}





	public Skiorder1 getSkiOneOrder(int s_orderid) {
		
		//리턴 타입선언
		Skiorder1 ssbean = null;
		try {
			getCon();
			String sql = "select * from reserve_ski where s_orderid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_orderid);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				ssbean = new Skiorder1();
				ssbean.setS_orderid(s_orderid);
				ssbean.setSkibeginday(rs.getString(1));
				ssbean.setSkiendday(rs.getString(2));
				ssbean.setSkisize(rs.getString(3));
				
				
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ssbean;
	}





	public void SkiOrderUpdate(Skiorder1 sbean) {
		try {
			getCon();
			String sql = "update reserve_ski set skibeginday =?,skiendday =?,skisize =? where s_orderid=? and memberpass=?";
				
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sbean.getSkibeginday());
			pstmt.setString(2, sbean.getSkiendday());
			pstmt.setString(3,sbean.getSkisize());
			pstmt.setInt(4, sbean.getS_orderid());
			pstmt.setString(5, sbean.getMemberpass());
			pstmt.executeUpdate();
			
			
			conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}





	public SkiClothOrder getSkiblothOneorder(int sc_orderid) {
		SkiClothOrder scbean = null;
		
		try {
			getCon();
			String sql = "select * from reserve_skicloth where sc_orderid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sc_orderid);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				scbean=new SkiClothOrder();
				scbean.setSc_orderid(sc_orderid);
				scbean.setSkiclothbeginday(rs.getString(1));
				scbean.setSkiclothendday(rs.getString(2));
				scbean.setSkiclothsize(rs.getString(3));
				
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scbean;
	}





	public void Skiclothupdate(SkiClothOrder scbean) {
	try {
		getCon();
		
		String sql = "update reserve_skicloth set skiclothbeginday =?,skiclothendday =?,skiclothsize =? where sc_orderid=? and memberpass=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, scbean.getSkiclothbeginday());
		pstmt.setString(2, scbean.getSkiclothendday());
		pstmt.setString(3, scbean.getSkiclothsize());
		pstmt.setInt(4, scbean.getSc_orderid());
		pstmt.setString(5, scbean.getMemberpass());
		pstmt.executeUpdate();
		
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}
}
