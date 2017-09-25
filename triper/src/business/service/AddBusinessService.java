package business.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.dao.BusinessDAO;
import business.vo.BusinessVO;

public class AddBusinessService implements Service {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BusinessVO vo = new BusinessVO();
		vo.setBusiness_name(request.getParameter("business_name"));
		vo.setBusiness_road_address(request.getParameter("business_road_address"));
		vo.setBusiness_address(request.getParameter("business_address"));
		vo.setBusiness_tel(request.getParameter("business_tel"));
		vo.setBusiness_id(request.getParameter("business_id"));
		vo.setBusiness_x(request.getParameter("business_x"));
		vo.setBusiness_y(request.getParameter("business_y"));
		vo.setBusiness_assent("대기중");
		vo.setBusiness_delete("N");
		vo.setBusiness_category(request.getParameter("business_category"));
		vo.setMember_id(request.getParameter("member_id"));
		
		BusinessDAO dao = new BusinessDAO();
		
		dao.addBusiness(vo);
	}
}
