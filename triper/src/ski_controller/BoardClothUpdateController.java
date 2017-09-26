package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ski_db.BoardClothOrder;
import ski_db.BoardDAO;

/**
 * Servlet implementation class BoardClothUpdateController
 */
@WebServlet("/BoardClothUpdateController1.do")
public class BoardClothUpdateController extends HttpServlet {
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
			
			String boardclothimg = request.getParameter("boardclothimg");
			int bl_orderid = Integer.parseInt(request.getParameter("bl_orderid"));
			
			BoardDAO bdao=new BoardDAO();
			BoardClothOrder bcp = bdao.getBoardClothprice(boardclothimg);
			BoardClothOrder bcpbean = bdao.getBoardClothoneprice(boardclothimg);
			BoardClothOrder bcbean = bdao.getboardbclothOneorder(bl_orderid);
			
						
			bcbean.setProduct_boardclothimg(boardclothimg);
			
	
			request.setAttribute("bcp", bcp);
			request.setAttribute("bcpbean",bcpbean);
			request.setAttribute("bcbean", bcbean);
			RequestDispatcher dis = request.getRequestDispatcher("/_ski/SkiMain.jsp?center=BoardClothUpdate.jsp");
			dis.forward(request, response);
		}

}
