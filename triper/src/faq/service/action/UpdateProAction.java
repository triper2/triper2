package faq.service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;
import faq.service.dao.AlbumDao;
import faq.service.domain.Album;
import com.oreilly.servlet.MultipartRequest;

import faq.service.util.FileUtil;

public class UpdateProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");

        MultipartRequest multi = FileUtil.createFile(request);
        //전송된이미지정보
        String service_img= multi.getFilesystemName("service_img");
        
        AlbumDao manager = AlbumDao.getInstance();      
        //인증
       String kim=null;
        System.out.println(multi.getParameter("service_pwd"));
        int check = manager.userCheck(Integer.parseInt(multi.getParameter("service_id")),multi.getParameter("service_pwd"));
                
        if(check==1){        
            String originImage = multi.getParameter("originImage");            

            Album album =new Album();        

            album.setService_id(Integer.parseInt(multi.getParameter("service_id")));
            album.setMember_id(multi.getParameter("member_id"));
            album.setService_email(multi.getParameter("service_email"));   
            album.setService_title(multi.getParameter("service_title"));
            album.setService_pwd(multi.getParameter("service_pwd"));
            album.setService_content(multi.getParameter("service_content"));
            album.setService_ip(request.getRemoteAddr());

            if(service_img !=null){      
                //이미지가 변경되었을 경우
                album.setService_img(FileUtil.rename(service_img));
            }else{
                //이미지가 변경되지 않았을경우
                album.setService_img(originImage);
            }
            manager.update(album);
            if(service_img !=null){
                FileUtil.removeFile(originImage);
            }
        }else{
            //비번이 틀려 인증 실패시 올리려고 전송된 이미지 삭제
            if(service_img !=null)FileUtil.removeFile(service_img);
        }
        
        request.setAttribute("check", new Integer(check));

        return "/_faq/service/updatePro.jsp;";
    }
}