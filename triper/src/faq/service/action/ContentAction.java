package faq.service.action;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import faq.service.controller.Action;
	import faq.service.dao.AlbumDao;
	import faq.service.domain.Album;

	public class ContentAction implements Action{

	    @Override
	    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
	        
	        request.setCharacterEncoding("utf-8");
	            
	        int service_id =Integer.parseInt(request.getParameter("service_id"));
	    
	        AlbumDao manager = AlbumDao.getInstance();
	        Album album = manager.getArticle(service_id);
	        
	        int service_ref = album.getService_ref();
			int service_re_step = album.getService_re_step();
			int service_level = album.getService_level();
	        
	        if(album !=null){
	            album.setService_readcount(manager.updateReadCount(service_id));
	        }        
	        
	        request.setAttribute("service_id", new Integer(service_id));
	        request.setAttribute("album", album);
	        
	        return "/faq/service/content.jsp;";
	    }
	
}
