package faq.service.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.service.controller.Action;

public class DeleteFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        

    	String service_id = request.getParameter("service_id");
    	String service_img = request.getParameter("service_img");

    	request.setAttribute("service_id", service_id);
    	request.setAttribute("service_img", service_img);
    	
        return "/_faq/service/deleteForm.jsp";
    }
}