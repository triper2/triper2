package faq.service.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringUtil {
    public static String clobToString(ResultSet rs, String msg) throws SQLException, IOException{
        StringBuffer sb = new StringBuffer();
        //getCharacterStream : String 으로 읽어드려 char 배열에넣고 StringqBuffer에 넣음
        Reader rd = rs.getCharacterStream(msg);
        char[] buffer = new char[1024];
        int byteRead;
        while((byteRead=rd.read(buffer,0,1024))!=-1){
            sb.append(buffer,0,byteRead);
        }
        rd.close();
        return sb.toString(); 
    }
}