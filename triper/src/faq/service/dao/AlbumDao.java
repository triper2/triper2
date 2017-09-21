package faq.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import faq.service.dao.AlbumDao;
import faq.service.domain.Album;

import faq.service.util.StringUtil;

public class AlbumDao {

    private static AlbumDao instance =new AlbumDao();

    //싱글턴 패턴
    private AlbumDao(){}
    public static AlbumDao getInstance(){
        return instance;
    }


    //getConnection : JDBC DB연동 
    private Connection getConnection() throws Exception{
        Context initCtx= new InitialContext();
        Context envCtx=(Context)initCtx.lookup("java:comp/env");
        DataSource ds=(DataSource)envCtx.lookup("jdbc:TriperDB");

        return ds.getConnection();
    }

    //글쓰기 등록
    public void insertArticle(Album album)throws Exception{

        Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql=null;
        int cnt = 0;  
        int service_id = album.getService_id();
        int service_ref = album.getService_ref();					//부모의 ref(그룹 번호)
		int service_re_step = album.getService_re_step();		//부모의 그룹내 순서
		int service_level = album.getService_level();	//부모의 그룹내 레벨
		int number = 0;							// board 테이블에 들어갈 번호
		StringBuffer sb = new StringBuffer();
		
		try {
			conn = getConnection();
			//현재 board 테이블에 레코드 유무 판단과 글 번호 지정
			pstmt = conn.prepareStatement("SELECT MAX(service_id) FROM service_board");
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				number = rs.getInt(1) + 1;     // 1 : num , 다음 글 번호는 가장 큰 번호 + 1 
			} else {
				number = 1;
			} // if end
			
			//제목글과 답변글 간의 순서 결정
			if( service_id != 0 ) {  //답변글
				service_level = service_level + 1;
				
				pstmt = conn.prepareStatement(
						"SELECT MAX(service_re_step) FROM service_board WHERE service_ref = ? AND service_level = ? ");
				pstmt.setInt(1, service_ref);
				pstmt.setInt(2, service_level);
				rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					if( service_re_step == 0 ) {
						service_re_step = rs.getInt(1) + 1;
					}
				} else {
					service_re_step = 0; 			// 첫번째 글
				} // in if end
				
			} else {				// 부모글인 경우 글번호 없음
				service_ref= number;
				service_re_step = 0;
				service_level = 0;
			} // out if end

            //빠지는게 있을때는 컬럼명을 다 넣어줘야함
            sql = "insert into service_board (service_id, member_id, service_title, service_email, service_content, service_pwd, service_reg_date, service_ip, service_img, service_ref, service_re_step, service_level) " +
                    "values(service_board_seq.nextval,?,?,?,?,?,sysdate,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(++cnt, album.getMember_id());
            pstmt.setString(++cnt, album.getService_title());
            pstmt.setString(++cnt, album.getService_email());
            pstmt.setString(++cnt, album.getService_content());
            pstmt.setString(++cnt, album.getService_pwd());
            pstmt.setString(++cnt, album.getService_ip());
            pstmt.setString(++cnt, album.getService_img());
            pstmt.setInt(++cnt, service_ref);
            pstmt.setInt(++cnt, service_re_step);
            pstmt.setInt(++cnt, service_level);
            
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }
    }    
    
    //글갯수
    public int getArticleCount(String keyField,String keyWord)throws Exception{
        Connection conn= null;
        PreparedStatement pstmt =null;
        ResultSet rs= null;
        int count =0;
        String sql =null;
        
        try{
            conn=getConnection();
            if(keyWord == null || "".equals(keyWord.trim())){
                sql="select count(*) from service_board";
                pstmt =conn.prepareStatement(sql);
            }else{
                sql="select count(*) from service_board where "+keyField+" like ?";
                pstmt =conn.prepareStatement(sql);
                pstmt.setString(1, "%"+keyWord+"%");
            }
            rs =pstmt.executeQuery();
            if (rs.next()){
                count =rs.getInt(1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{ 
            execClose(rs,pstmt,conn);
        }            
        return count;
    }
    
    //리스트뽑기
    public List<Album> getArticles(int startRow, int endRow, String keyField,String keyWord)throws Exception{
        Connection conn= null;
        PreparedStatement pstmt =null;
        ResultSet rs= null;
        List<Album> list =null;
        String sql=null;
        
        try{
            conn =getConnection();
            if(keyWord == null || "".equals(keyWord.trim())){
                sql ="select * from (select a.*, rownum rnum from (select * from service_board order by service_ref desc, service_re_step ASC)a) where rnum >=? and rnum <=?";
                pstmt =conn.prepareStatement(sql);            
                pstmt.setInt(1, startRow);
                pstmt.setInt(2, endRow);    
            }else{
                sql ="select * from(select a.*, rownum rnum from(select * from service_board where "+keyField+" like ? order by service_id desc)a) where rnum >=? and rnum <=?";
                pstmt =conn.prepareStatement(sql);    
                pstmt.setString(1, "%"+keyWord+"%");
                pstmt.setInt(2, startRow);
                pstmt.setInt(3, endRow);
            }
            rs = pstmt.executeQuery();
            if(rs.next()){
                list= new ArrayList<Album>();                
                do{
                    Album album =new Album();
                    album.setService_id(rs.getInt("service_id"));
                    album.setMember_id(rs.getString("member_id"));
                    album.setService_title(rs.getString("service_title"));
                    album.setService_email(rs.getString("service_email"));
                    album.setService_pwd(rs.getString("service_pwd"));
                    album.setService_reg_date(rs.getTimestamp("service_reg_date"));
                    album.setService_ip(rs.getString("service_ip"));
                    album.setService_img(rs.getString("service_img"));                            
                    album.setService_readcount(rs.getInt("service_readcount"));
                    album.setService_content(StringUtil.clobToString(rs,"service_content"));
                    album.setService_ref(rs.getInt("service_ref"));
                    album.setService_re_step(rs.getInt("service_re_step"));
                    album.setService_level(rs.getInt("service_level"));
                    list.add(album);
                }while(rs.next());
            }else{
                list = Collections.EMPTY_LIST;
            }            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }        
        return list;
    }
    
    //상세페이지
    public Album getArticle(int service_id)throws Exception{
        Connection conn =null;
        PreparedStatement  pstmt= null;
        ResultSet rs = null;
        Album album =null;
        String sql=null;
        
        try{
            conn=getConnection();
            sql ="select * from service_board where service_id = ? ";

            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, service_id);
            rs=pstmt.executeQuery();
            
            if(rs.next()){
                album =new Album();
                album.setService_id(rs.getInt("service_id"));
                album.setMember_id(rs.getString("member_id"));
                album.setService_title(rs.getString("service_title"));
                album.setService_email(rs.getString("service_email"));
                album.setService_pwd(rs.getString("service_pwd"));
                album.setService_reg_date(rs.getTimestamp("service_reg_date"));
                album.setService_ip(rs.getString("service_ip"));
                album.setService_img(rs.getString("service_img"));            
                album.setService_readcount(rs.getInt("service_readcount"));
                album.setService_content(StringUtil.clobToString(rs,"service_content"));
                album.setService_ref(rs.getInt("service_ref"));
                album.setService_re_step(rs.getInt("service_re_step"));
                album.setService_level(rs.getInt("service_level"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }
        return album;
    }
    
    //조회수증가
    public int updateReadCount(int service_id)throws Exception{
        Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int count =0;
        String sql =null;
        
        try{
            conn=getConnection();
            
            //조회수 증가
            sql="update service_board set service_readcount=service_readcount+1 where service_id = ?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, service_id);
            pstmt.executeUpdate();
            
            //증가된 조회수 조회
            sql="select service_readcount from service_board where service_id = ?";
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1, service_id);
            rs= pstmt.executeQuery();
            
            if(rs.next()){
                count =rs.getInt(1);
            }            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(null,pstmt,conn);
        }            
        return count;
    }
    
    //수정
    public void update(Album album)throws Exception{
            Connection conn=null;
            PreparedStatement pstmt =null;
            int cnt =0;
            String sql = null;
            
            try{
                conn =getConnection();
                sql = "update service_board set service_email=?, service_title=?, service_img=?, service_content=?, service_pwd=? where service_id=?";
                pstmt =conn.prepareStatement(sql);
                pstmt.setString(++cnt, album.getService_email());
                pstmt.setString(++cnt, album.getService_title());    
                pstmt.setString(++cnt, album.getService_img());    
                pstmt.setString(++cnt, album.getService_content()); 
                pstmt.setString(++cnt, album.getService_pwd());
                pstmt.setInt(++cnt, album.getService_id());
                
                
                pstmt.executeUpdate();
                
            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                execClose(null,pstmt,conn);
            }
    }
    
    //삭제
    public void  deleteArticle(int service_id)throws Exception{
        Connection conn =null;
        PreparedStatement pstmt=null;
        String sql=null;        
        
        try{            
            conn= getConnection();
            
            sql="delete from service_board where service_id=?";
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1, service_id);
            pstmt.executeUpdate();

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(null,pstmt,conn);
        }        
        return ;
    }
        
    //인증
    public int userCheck(int service_id, String service_pwd)throws Exception{
        Connection conn =null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String dbpasswd="";
        String sql="";
        int x=-1;
        try{

            conn= getConnection();
            sql="select service_pwd from service_board where service_id=?";
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1, service_id);
            rs=pstmt.executeQuery();

            if(rs.next()){
                dbpasswd =rs.getString("service_pwd");
                if(dbpasswd.equals(service_pwd)){
                    x=1;//인증성공
                }else{
                    //x=0;//비밀전호 틀림
                	x=0;
                }
            }            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }        
        return x;
    }

    //execClose : 자원정리
    public void execClose(ResultSet rs, PreparedStatement pstmt, Connection conn)throws Exception{
        if(rs !=null) try{rs.close();}catch(SQLException sqle){}
        if(pstmt !=null) try{pstmt.close();}catch(SQLException sqle){}
        if(conn !=null) try{conn.close();}catch(SQLException sqle){}
    }
}