package faq.service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;
import faq.service.dao.AlbumDao;
import faq.service.domain.Album;

public class CheckFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        String service_pwd = request.getParameter("service_pwd");
        //System.out.println("service_id" + service_id);
        //System.out.println("service_pwd" + service_pwd);
    	
        AlbumDao manager = AlbumDao.getInstance();
        Album album = manager.getArticle(service_id);        
        
       	request.setAttribute("service_id", service_id);
        request.setAttribute("album", album);
        

        return "/_faq/service/checkForm.jsp";
    }
}
