package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiClothOrder;
import ski_db.SkiDAO;

/**
 * Servlet implementation class SkiClothorder
 */
@WebServlet("/SkiClothorder.do")
public class SkiClothorder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
		}
		protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			SkiClothOrder bean = new SkiClothOrder();
			
		bean.setSkiclothbeginday(request.getParameter("skiclothbeginday"));
		bean.setSkiclothendday(request.getParameter("skiclothendday"));
		bean.setSkiclothsize(request.getParameter("skiclothsize"));
		bean.setProduct_skiclothno(Integer.parseInt(request.getParameter("product_skiclothno")));
		bean.setProduct_skiclothname(request.getParameter("product_skiclothname"));
		bean.setProduct_skiclothprice(Integer.parseInt(request.getParameter("product_skiclothprice")));
		bean.setProduct_skiclothimg(request.getParameter("product_skiclothimg"));
		bean.setMemberphone(request.getParameter("memberphone"));
		bean.setMemberpass(request.getParameter("memberpass"));
		
		SkiDAO dao = new SkiDAO();
		
		dao.insertskiclothOrder(bean);
		
		RequestDispatcher dis = request.getRequestDispatcher("SkiClothListController.do");
		dis.forward(request, response);
		}

}
