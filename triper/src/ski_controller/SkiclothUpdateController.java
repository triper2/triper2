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
 * Servlet implementation class SkiclothUpdateController
 */
@WebServlet("/SkiclothUpdateController.do")
public class SkiclothUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	requestpro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestpro(request, response);
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String skiclothimg = request.getParameter("skiclothimg");
		int sc_orderid = Integer.parseInt(request.getParameter("sc_orderid"));
		
		SkiDAO sdao=new SkiDAO();
		
		SkiClothOrder scpbean = sdao.getSkiclothOneprice(skiclothimg);
		SkiClothOrder scbean = sdao.getSkiblothOneorder(sc_orderid);
		scbean.setProduct_skiclothimg(skiclothimg);
		
		
		request.setAttribute("scpbean", scpbean);
		request.setAttribute("scbean", scbean);
		RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=SkiClothUpdate.jsp");
		dis.forward(request, response);
	}

}
