package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiDAO;
import ski_db.Skiorder1;


@WebServlet("/SkiOrder.do")
public class SkiOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Skiorder1 bean = new Skiorder1();
		
		
	bean.setSkibeginday(request.getParameter("skibeginday"));
	bean.setSkiendday(request.getParameter("skiendday"));
	bean.setSkisize(request.getParameter("skisize"));
	bean.setProduct_skino(Integer.parseInt(request.getParameter("product_skino")));
	bean.setProduct_skiname(request.getParameter("product_skiname"));
	bean.setProduct_skiprice(Integer.parseInt(request.getParameter("product_skiprice")));
	bean.setProduct_skiimg(request.getParameter("product_skiimg"));
	bean.setMemberphone(request.getParameter("memberphone"));
	bean.setMemberpass(request.getParameter("memberpass"));
	
		SkiDAO dao = new SkiDAO();
	
		dao.insertSkiOrder(bean);
	
		RequestDispatcher dis = request.getRequestDispatcher("SkiListController1.do");
		dis.forward(request, response);
	}

	

}
