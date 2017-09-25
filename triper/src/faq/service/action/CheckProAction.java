package faq.service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;
import faq.service.dao.AlbumDao;
import faq.service.domain.Album;
import faq.service.util.FileUtil;

public class CheckProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
    	
    	request.setCharacterEncoding("utf-8");
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        String service_pwd = request.getParameter("service_pwd");
        //System.out.println("service_id" + service_id);
        AlbumDao manager = AlbumDao.getInstance();
        int check = manager.userCheck(service_id, service_pwd);

        if(check== 1){     
            
        	Album album = manager.getArticle(service_id);
            
       
        }                   
        request.setAttribute("service_id", service_id);
        request.setAttribute("check", new Integer(check));
        
        //System.out.println("service_id2" + service_id);
        return "/_faq/service/checkPro.jsp";
    }
}
