package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.SkiOrder;
import ski_db.Skiorder1;


@WebServlet("/SkiReservation.do")
public class SkiReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skibeginday=request.getParameter("skibeginday");
		String skiendday=request.getParameter("skiendday");
		String skisize=request.getParameter("skisize");
		int skino =Integer.parseInt(request.getParameter("skino"));
		String product_skiname=request.getParameter("product_skiname");
		int skiprice =Integer.parseInt(request.getParameter("skiprice"));
		String product_skiimg = request.getParameter("product_skiimg");
		
		int total = skiprice;
		
		Skiorder1 bean = new Skiorder1();
		bean.setSkibeginday(skibeginday);
		bean.setSkiendday(skiendday);
		bean.setSkisize(skisize);
		bean.setProduct_skino(Integer.parseInt(request.getParameter("skino")));
		bean.setProduct_skiname(product_skiname);
		bean.setProduct_skiprice(Integer.parseInt(request.getParameter("skiprice")));
		bean.setProduct_skiimg(product_skiimg);
		
		
		request.setAttribute("bean", bean);
		request.setAttribute("total", total);
	
	
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiReserve.jsp");
		dis.forward(request, response);
		
	}

}
