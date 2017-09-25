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
 * Servlet implementation class SkiClothUpdateProcController
 */
@WebServlet("/SkiClothUpdateProcController.do")
public class SkiClothUpdateProcController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}

	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sc_orderid=Integer.parseInt(request.getParameter("sc_orderid"));
		String skiclothimg = request.getParameter("skiclothimg");
		String skiclothbeginday = request.getParameter("skiclothbeginday");
		String skiclothendday= request.getParameter("skiclothendday");
		String skiclothsize = request.getParameter("skiclothsize");
		
		String memberpass = request.getParameter("memberpass");
		System.out.println(sc_orderid);
		System.out.println(skiclothbeginday);
		System.out.println(skiclothendday);
		System.out.println(skiclothsize);
		
		SkiClothOrder scbean = new SkiClothOrder();
		scbean.setSc_orderid(sc_orderid);
		scbean.setSkiclothbeginday(skiclothbeginday);
		scbean.setSkiclothendday(skiclothendday);
		scbean.setSkiclothsize(skiclothsize);
		scbean.setMemberpass(memberpass);
		
		
		SkiDAO sdao = new SkiDAO();
		
		sdao.Skiclothupdate(scbean);
		
		request.setAttribute("scbean", scbean);
		RequestDispatcher dis = request.getRequestDispatcher("/SkiClothListController.do");
		dis.forward(request, response);
		
	}
}
