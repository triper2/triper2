package business.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.dao.BusinessDAO;
import business.vo.BusinessVO;
import kosta.rental.loginModel.RentalDTO;

public class assentBusinessService implements Service {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BusinessDAO dao = new BusinessDAO();
		System.out.println(request.getParameter("business_id"));
		dao.assentBusiness(request.getParameter("business_id"));
	}
}
