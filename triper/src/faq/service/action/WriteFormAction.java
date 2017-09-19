package faq.service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;

public class WriteFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        
		int service_id = 0, service_ref=1, service_re_step=0, service_level=0;
		
		try{
			if( request.getParameter("service_id") !=null ){  //답변글
				service_id = Integer.parseInt(request.getParameter("service_id"));
				service_ref = Integer.parseInt(request.getParameter("service_ref"));
				service_re_step = Integer.parseInt(request.getParameter("service_re_step"));
				service_level = Integer.parseInt(request.getParameter("service_level"));		
			}//if end
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//해당 뷰에서 사용할 속성(저장)
		request.setAttribute("service_id", service_id);
		request.setAttribute("service_ref", service_ref);
		request.setAttribute("service_re_step", service_re_step);
		request.setAttribute("service_level", service_level);
		
		
        return "/faq/service/writeForm.jsp";
    }
}