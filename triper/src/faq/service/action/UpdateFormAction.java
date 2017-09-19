package faq.service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;
import faq.service.dao.AlbumDao;
import faq.service.domain.Album;

public class UpdateFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        
        AlbumDao manager = AlbumDao.getInstance();
        Album album = manager.getArticle(service_id);        

        request.setAttribute("album", album);
        
        return "/faq/service/updateForm.jsp";
    }
}