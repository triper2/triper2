package faq.service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;
import faq.service.dao.AlbumDao;
import faq.service.domain.Album;
import com.oreilly.servlet.MultipartRequest;

import faq.service.util.FileUtil;

public class WriteProAction  implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        MultipartRequest multi =FileUtil.createFile(request);
        
        Album album = new Album();
        album.setService_id(Integer.parseInt(multi.getParameter("service_id")));
        album.setMember_id(multi.getParameter("member_id"));
        album.setService_title(multi.getParameter("service_title"));
        album.setService_email(multi.getParameter("service_email"));
        album.setService_content(multi.getParameter("service_content"));
        album.setService_pwd(multi.getParameter("service_pwd"));
        album.setService_ip(request.getRemoteAddr());
        //image 파라미터네임
        album.setService_img(FileUtil.rename(multi.getFilesystemName("service_img")));
        
        album.setService_ref(Integer.parseInt(multi.getParameter("service_ref")));
        album.setService_re_step(Integer.parseInt(multi.getParameter("service_re_step")));
        album.setService_level(Integer.parseInt(multi.getParameter("service_level")));
        
        AlbumDao manager = AlbumDao.getInstance();
        manager.insertArticle(album);
        
        return "/faq/service/writePro.jsp";
    }
}