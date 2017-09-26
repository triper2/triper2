package ski_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAO {
	
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
	
	public Vector<BoardListBean> getAllBoardlist() {
		//리턴할 vector 객체 선언
				Vector<BoardListBean> v = new Vector<BoardListBean>();
				BoardListBean bean = null;
				
				try {
					getCon();
					String sql = "select * from product_board_list";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					while(rs.next()){
						
						bean = new BoardListBean();
					
						bean.setProduct_boardno(rs.getInt(1));
						bean.setProduct_boardname(rs.getString(2));
						bean.setProduct_boardprice(rs.getInt(3));
						bean.setProduct_boardinfo(rs.getString(4));
						bean.setProduct_boardimg(rs.getString(5));
						v.add(bean);
					}
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return v;
	}

	public BoardListBean getOneBoard(int boardno) {
		BoardListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_board_list where product_boardno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new BoardListBean();
				bean.setProduct_boardno(rs.getInt(1));
				bean.setProduct_boardname(rs.getString(2));
			
				bean.setProduct_boardprice(rs.getInt(3));
				
				bean.setProduct_boardinfo(rs.getString(4));
				bean.setProduct_boardimg(rs.getString(5));
				
			
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public Vector<BoardClothListBean> getAllBoardclothlist() {
		//리턴할 vector 객체 선언
		Vector<BoardClothListBean> v = new Vector<BoardClothListBean>();
		BoardClothListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_boardcloth_list";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				bean = new BoardClothListBean();
			
				bean.setProduct_boardclothno(rs.getInt(1));
				bean.setProduct_boardclothname(rs.getString(2));
				bean.setProduct_boardclothprice(rs.getInt(3));
				bean.setProduct_boardclothinfo(rs.getString(4));
				bean.setProduct_boardclothimg(rs.getString(5));
				v.add(bean);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}

	public BoardClothListBean getOneBoardcloth(int boardclothno) {
		BoardClothListBean bean = null;
		
		try {
			getCon();
			String sql = "select * from product_boardcloth_list where product_boardclothno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardclothno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				bean = new BoardClothListBean();
				bean.setProduct_boardclothno(rs.getInt(1));
				bean.setProduct_boardclothname(rs.getString(2));
			
				bean.setProduct_boardclothprice(rs.getInt(3));
				
				bean.setProduct_boardclothinfo(rs.getString(4));
				bean.setProduct_boardclothimg(rs.getString(5));
				
			
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public void insertBoardclothOrder(BoardClothOrder bean) {
		try {
			getCon();
			//쿼리
			String sql = "insert into reserve_boardcloth values(bc_orderid_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			
			
			//실행할 객체 선언
			pstmt=conn.prepareStatement(sql);
			//? 값 대입
			pstmt.setString(1, bean.getBoardclothbeginday());
			pstmt.setString(2, bean.getBoardclothendnday());
			pstmt.setString(3, bean.getBoardclothsize());
			pstmt.setInt(4, bean.getProduct_boardclothno());
			pstmt.setString(5, bean.getProduct_boardclothname());
			pstmt.setInt(6, bean.getProduct_boardclothprice());
			pstmt.setString(7, bean.getProduct_boardclothimg());
			pstmt.setString(8, bean.getMemberphone());
			pstmt.setString(9, bean.getMemberpass());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void insertBoardorder(BoardOrder bean) {
		try {
			getCon();
			//쿼리
			String sql = "insert into reserve_board values(b_orderid_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
			
			
			//실행할 객체 선언
			pstmt=conn.prepareStatement(sql);
			//? 값 대입
			pstmt.setString(1, bean.getBoardbeginday());
			pstmt.setString(2, bean.getBoardendday());
			pstmt.setString(3, bean.getBoardsize());
			pstmt.setInt(4, bean.getProduct_boardno());
			pstmt.setString(5, bean.getProduct_boardname());
			pstmt.setInt(6, bean.getProduct_boardprice());
			pstmt.setString(7, bean.getProduct_boardimg());
			pstmt.setString(8, bean.getMemberphone());
			pstmt.setString(9, bean.getMemberpass());
			
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Vector<BoardOrder> getAllBoardOrder(String memberphone, String memberpass) {

		//return 타입
		Vector<BoardOrder> bv =new Vector<BoardOrder>();
		
		BoardOrder bbean = null;
		
		try {
			
			getCon();
			String sql ="select * from reserve_board where "
					+ "sysdate < to_date(boardbeginday , 'YYYY-MM-DD') "
					+ "and memberphone=? and memberpass=?";
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberphone);
			pstmt.setString(2, memberpass);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				bbean = new BoardOrder();
				bbean.setB_orderid(rs.getInt(1));
				bbean.setBoardbeginday(rs.getString(2));
				bbean.setBoardendday(rs.getString(3));
				bbean.setBoardsize(rs.getString(4));
				bbean.setProduct_boardname(rs.getString(6));
				bbean.setProduct_boardprice(rs.getInt(7));
				bbean.setProduct_boardimg(rs.getString(8));
				bv.add(bbean);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bv;

	}

	public Vector<BoardClothOrder> getAllBoardClothOrder(String memberphone, String memberpass) {
		//return 타입
		Vector<BoardClothOrder> bcv =new Vector<BoardClothOrder>();
		
		BoardClothOrder bcbean = null;
		
		try {
			
			getCon();
			String sql ="select * from reserve_boardcloth where "
					+ "sysdate < to_date(boardclothbeginday , 'YYYY-MM-DD') "
					+ "and memberphone=? and memberpass=?";
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberphone);
			pstmt.setString(2, memberpass);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				bcbean = new BoardClothOrder();
				bcbean.setBl_orderid(rs.getInt(1));
				bcbean.setBoardclothbeginday(rs.getString(2));
				bcbean.setBoardclothendnday(rs.getString(3));
				bcbean.setBoardclothsize(rs.getString(4));
				bcbean.setProduct_boardclothname(rs.getString(6));
				bcbean.setProduct_boardclothprice(rs.getInt(7));
				bcbean.setProduct_boardclothimg(rs.getString(8));
				bcv.add(bcbean);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bcv;
	}

	public int BoardDelete(int b_orderid, String memberpass) {
		int result2=0;
		try {
			getCon();
			
			String sql ="delete from reserve_board where b_orderid=? and memberpass=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값을 대입
			pstmt.setInt(1, b_orderid);
			pstmt.setString(2, memberpass);
			//쿼리가 실행되지 않았다면 0값이 리턴 실행이 되면 1이 리턴됩니다.
			result2 = pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result2;

	}

	public int BoardclothDelete(int bl_orderid, String memberpass) {
		int result3=0;
		try {
			getCon();
			
			String sql ="delete from reserve_boardcloth where bc_orderid=? and memberpass=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값을 대입
			pstmt.setInt(1, bl_orderid);
			pstmt.setString(2, memberpass);
			//쿼리가 실행되지 않았다면 0값이 리턴 실행이 되면 1이 리턴됩니다.
			result3 = pstmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result3;
	}

	public BoardOrder getBoardOneOrder(int b_orderid) {
		BoardOrder bbean = null;
		try {
			getCon();
			String sql="select * from reserve_board where b_orderid=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, b_orderid);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				bbean = new BoardOrder();
				bbean.setB_orderid(b_orderid);
				bbean.setBoardbeginday(rs.getString(1));
				bbean.setBoardendday(rs.getString(2));
				bbean.setBoardsize(rs.getString(3));
				
				
			}
			
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bbean;
	}

	public void Boardupdate(BoardOrder bbean) {
		try {
			getCon();
			String sql =  "update reserve_board set boardbeginday =?,boardendday =?,boardsize =?,product_boardprice=? where b_orderid=? and memberpass=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bbean.getBoardbeginday());
			pstmt.setString(2, bbean.getBoardendday());
			pstmt.setString(3, bbean.getBoardsize());
			pstmt.setInt(4, bbean.getProduct_boardprice());
			pstmt.setInt(5,bbean.getB_orderid());
			pstmt.setString(6, bbean.getMemberpass());
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public BoardClothOrder getboardbclothOneorder(int bl_orderid) {
		BoardClothOrder bcbean = null;
		
		try {
			getCon();
			String sql = "select * from reserve_boardcloth where bc_orderid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bl_orderid);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				bcbean=new BoardClothOrder();
				bcbean.setBl_orderid(bl_orderid);
				bcbean.setBoardclothbeginday(rs.getString(1));
				bcbean.setBoardclothendnday(rs.getString(2));
				bcbean.setBoardclothsize(rs.getString(3));
				
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bcbean;
	}

	public void BoardClothupdate(BoardClothOrder bcbean) {
		try {
			getCon();
			
			String sql = "update reserve_boardcloth set boardclothbeginday =?,boardclothendnday =?,boardclothsize =?,product_boardclothprice=? where bl_orderid=? and memberpass=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bcbean.getBoardclothbeginday());
			pstmt.setString(2, bcbean.getBoardclothendnday());
			pstmt.setString(3, bcbean.getBoardclothsize());
			pstmt.setInt(4, bcbean.getProduct_boardclothprice());
			pstmt.setInt(5, bcbean.getBl_orderid());
			pstmt.setString(6, bcbean.getMemberpass());
			pstmt.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}

	public BoardOrder getBoardOneprice(String boardimg) {
		BoardOrder bpbean = null;
		try {
			getCon();
			String sql = "select * from product_board_list where product_boardimg=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, boardimg);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				bpbean = new BoardOrder();
				bpbean.setProduct_boardimg(boardimg);
				bpbean.setProduct_boardprice(rs.getInt(3));
				
			}
			conn.close();
		} catch (Exception e) {
			
		}
		return bpbean;
	}

	public BoardClothOrder getBoardClothoneprice(String boardclothimg) {
		BoardClothOrder bcpbean = null;
		try {
			getCon();
			String sql = "select * from product_boardcloth_list where product_boardclothimg=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, boardclothimg);
			pstmt.executeQuery();
			while(rs.next()){
				bcpbean = new BoardClothOrder();
				bcpbean.setProduct_boardclothimg(boardclothimg);
				bcpbean.setProduct_boardclothprice(rs.getInt(3));
				
				
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bcpbean;
	}

	public void insertboardAdd(BoardListBean bbean) {
	try {
			
			getCon();
			String sql="insert into product_board_list values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, bbean.getProduct_boardno());
			pstmt.setString(2, bbean.getProduct_boardname());
			pstmt.setInt(3, bbean.getProduct_boardprice());
			pstmt.setString(4, bbean.getProduct_boardinfo());
			pstmt.setString(5,bbean.getProduct_boardimg());
		
			
			pstmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertboardclothAdd(BoardClothListBean bcbean) {
try {
			
			getCon();
			String sql="insert into product_boardcloth_list values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, bcbean.getProduct_boardclothno());
			pstmt.setString(2, bcbean.getProduct_boardclothname());
			pstmt.setInt(3, bcbean.getProduct_boardclothprice());
			pstmt.setString(4, bcbean.getProduct_boardclothinfo());
			pstmt.setString(5,bcbean.getProduct_boardclothimg());
		
			
			pstmt.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BoardClothOrder getBoardClothprice(String boardclothimg) {
		BoardClothOrder bcp = null;
		try {
			getCon();
			String sql = "select * from product_boardcloth_list where product_boardclothimg=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, boardclothimg);
			pstmt.executeQuery();
			while(rs.next()){
				bcp = new BoardClothOrder();
				bcp.setProduct_boardclothimg(boardclothimg);
				bcp.setProduct_boardclothprice(rs.getInt(3));
				
				
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bcp;
	}
}
