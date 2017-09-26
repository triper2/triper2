package search;

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

import faq.service.domain.Album;
import faq.service.util.StringUtil;
import search.SearchVo;
import search.SearchDao;

public class SearchDao {
	private static SearchDao instance =new SearchDao();
	
	private SearchDao(){}
	
	public static SearchDao getInstance(){
		return instance;
	}
	
	//getConnection : JDBC DB연동 
    private Connection getConnection() throws Exception{
        Context initCtx= new InitialContext();
        Context envCtx=(Context)initCtx.lookup("java:comp/env");
        DataSource ds=(DataSource)envCtx.lookup("jdbc:TriperDB");

        return ds.getConnection();
    }
    
    public List<SearchVo> SearchList(String table, String column, String input) throws Exception{
    	Connection conn= null;
        PreparedStatement pstmt =null;
        ResultSet rs= null;
        String sql=null;
        List<SearchVo> list=null;
        List<Album> list2 =null;

        
        try{
        	conn =getConnection();
        	//sql = "select * from ? where ? like ? " ;
        	sql = "select * from " + table;
        	if(input!="")
        		sql += " where " + column + " like '%"+ input + "%'";
        	pstmt =conn.prepareStatement(sql);
        	SearchVo vo = new SearchVo();
        	//pstmt.setString(1, table);
        	//pstmt.setString(2, column);
        	//pstmt.setString(1, "%"+input+"%");
        	System.out.println("input" + input);
        	System.out.println("sql: " + sql);
        	System.out.println("rs" + rs);
        	rs = pstmt.executeQuery();
        	System.out.println("rs2" + rs);
        	if(rs.next()){
                list2= new ArrayList<Album>();                
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
                    list2.add(album);
                    
                    
                }while(rs.next());
            }else{
                list2 = Collections.EMPTY_LIST;
            }            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            rs.close();
            pstmt.close();
            conn.close();
        }
		return list;   
    }
    
}
