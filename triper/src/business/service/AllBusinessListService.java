package business.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.dao.BusinessDAO;
import business.vo.BusinessVO;
import kosta.rental.loginModel.RentalDTO;

public class AllBusinessListService implements Service {
	ArrayList<BusinessVO> list;
	public ArrayList<BusinessVO> getList() {
		return list;
	}
	public void setList(ArrayList<BusinessVO> list) {
		this.list = list;
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BusinessDAO dao = new BusinessDAO();
		list = dao.allBusinessList();
	}
}
