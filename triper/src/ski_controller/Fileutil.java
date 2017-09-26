package ski_controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class Fileutil {
    public static final String UPLOAD_PATH = "C:/Users/Administrator/web/SkiReserVation/WebContent/img"; //������
    public static final String  ENCODING_TYPE = "utf-8";
    public static final int MAX_SIZE = 10*1024*1024;//10M
    
    public static  MultipartRequest createFile(HttpServletRequest request) throws IOException{
        return new MultipartRequest(request,UPLOAD_PATH,MAX_SIZE,ENCODING_TYPE,new DefaultFileRenamePolicy());
    }
    
    //�˾Ƽ� ���ϸ��� �������
    public static String rename(String filename) throws Exception{
        if(filename ==null) return null;
        String newName = Long.toString(System.currentTimeMillis())+(int)(Math.random()*50);
        return rename(filename, newName);
    }
    
    //������ ���ϸ��� ����Ѵ�.
    public static String rename(String filename, String newName) throws Exception{
        if(filename == null) return null;
        File file = new File(UPLOAD_PATH,filename);
        //���ϸ��� ���ϴ� �������� �����ϱ�
        int idx = filename.lastIndexOf(".");
        String extention = "";
        String newFileName = "";

        if(idx != -1) {
            extention = filename.substring(idx);
        }
        // newName ���޽� Ȯ���ڸ� �����ؾ� ������ Ȯ���ڸ� ������ ��� ������
        int newIdx = newName.lastIndexOf(".");
        if(newIdx !=-1){
            newName = newName.substring(0,newIdx);
        }

        newFileName = newName + extention.toLowerCase();
        File fs = new File(UPLOAD_PATH,newFileName);
        file.renameTo(fs);

        return newFileName;
    }
    
    //���ϻ���
    public static void removeFile(String filename){
        if(filename != null){
            File file = new File(UPLOAD_PATH,filename);
            if(file.exists()) file.delete();
        }
    }

}
