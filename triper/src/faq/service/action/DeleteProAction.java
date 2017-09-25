package faq.service.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;
import faq.service.dao.AlbumDao;
import faq.service.domain.Album;

import faq.service.util.FileUtil;

public class DeleteProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");
/*
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        String service_pwd = request.getParameter("service_pwd");

        AlbumDao manager = AlbumDao.getInstance();
        	
        

            Album album = manager.getArticle(service_id);
            manager.deleteArticle(service_id);
            
            if(album.getService_img() != null){
                FileUtil.removeFile(album.getService_img());                
            }
            
            request.setAttribute("album", album);;*/
            
         // TODO Auto-generated method stub
    		String member_id = "123";
    		int service_id = 0;

    	/*	if (session.getAttribute("member_ID") != null) {
    			member_ID = (String) session.getAttribute("member_ID");
    		}*/
    		if (request.getParameter("service_id") != null) {
    			service_id = Integer.parseInt(request.getParameter("service_id"));
    			
    		}
    		if (member_id == null) {
    			PrintWriter script;
    			try {
    				script = response.getWriter();
    				script.println("<script>");
    				script.println("alert('로그인을 하세요')");
    				script.println("location.href = 'login.jsp'");// 로그인 페이지
    				script.println("</script>");
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    		} else {

    			AlbumDao dao = AlbumDao.getInstance();
    			int result = dao.deleteArticle(service_id);
    			if (result == -1) {
    				PrintWriter script;
    				try {
    					script = response.getWriter();
    					script.println("<script>");
    					script.println("alert('글 삭제에 실패했습니다')");
    					script.println("history.back()");
    					script.println("</script>");
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}

    			} else {

    				PrintWriter script;
    				try {
    					script = response.getWriter();
    					script.println("<script>");
    					script.println("location.href = 'list.service'");// 로그인 페이지
    					script.println("</script>");
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}

    			}
    			
    		}

        
        return "/_faq/service/deletePro.jsp";
    }
}