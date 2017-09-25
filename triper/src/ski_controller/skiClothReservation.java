package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiClothOrder;


@WebServlet("/skiClothReservation.do")
public class skiClothReservation extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
		}
		protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String skiclothbeginday=request.getParameter("skiclothbeginday");
			String skiclothendday=request.getParameter("skiclothendday");
			String skiclothsize=request.getParameter("skiclothsize");
			int skiclothno =Integer.parseInt(request.getParameter("skiclothno"));
			String product_skiclothname=request.getParameter("product_skiclothname");
			int skiclothprice =Integer.parseInt(request.getParameter("skiclothprice"));
			String product_skiclothimg = request.getParameter("product_skiclothimg");
			
			int total = skiclothprice;
			
			SkiClothOrder bean = new SkiClothOrder();
			bean.setSkiclothbeginday(skiclothbeginday);
			bean.setSkiclothendday(skiclothendday);
			bean.setSkiclothsize(skiclothsize);
			bean.setProduct_skiclothno(Integer.parseInt(request.getParameter("skiclothno")));
			bean.setProduct_skiclothname(product_skiclothname);
			bean.setProduct_skiclothprice(Integer.parseInt(request.getParameter("skiclothprice")));
			bean.setProduct_skiclothimg(product_skiclothimg);
			request.setAttribute("bean", bean);
			request.setAttribute("total", total);
		
		
			
			
			RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiClothReserve.jsp");
			dis.forward(request, response);
			
		}

}
