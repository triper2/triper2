package ski_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import ski_db.BoardClothListBean;
import ski_db.BoardDAO;
import ski_db.BoardListBean;
import ski_db.SkiClothListBean;
import ski_db.SkiDAO;
import ski_db.SkiListBean;


/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController.do")
public class AddController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			requestpro(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			requestpro(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void requestpro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html;charset=UTF-8");
	
		
		MultipartRequest multi = Fileutil.createFile(request);
		   
		   multi.getParameter("ski");
		  
		   System.out.println(multi.getParameter("ski"));
		   if(multi.getParameter("ski").equals("ski")){
			   
			   String product_skiimg = multi.getFilesystemName("img");
			    String product_skiinfo=multi.getFilesystemName("info");
			    SkiListBean sbean = new SkiListBean();
			   
			    
				sbean.setProduct_skino(Integer.parseInt(multi.getParameter("no")));

				sbean.setProduct_skiname(multi.getParameter("name")); 
				sbean.setProduct_skiprice(Integer.parseInt(multi.getParameter("price"))); 
				sbean.setProduct_skiinfo(Fileutil.rename(multi.getFilesystemName("info")));
				sbean.setProduct_skiimg(Fileutil.rename(multi.getFilesystemName("img")));
				SkiDAO sdao = new SkiDAO();
				//주문 현황을 저장
				sdao.insertskiAdd(sbean);
				RequestDispatcher dis =request.getRequestDispatcher("SkiListController1.do");
				dis.forward(request, response);
				
		   }else if(multi.getParameter("ski").equals("skicloth")){
			   String product_skiclothimg = multi.getFilesystemName("img");
			    String product_skiclothinfo=multi.getFilesystemName("info");
			    SkiClothListBean scbean = new SkiClothListBean();
			   
			    
				scbean.setProduct_skiclothno(Integer.parseInt(multi.getParameter("no")));

				scbean.setProduct_skiclothname(multi.getParameter("name")); 
				scbean.setProduct_skiclothprice(Integer.parseInt(multi.getParameter("price"))); 
				scbean.setProduct_skiclothinfo(Fileutil.rename(multi.getFilesystemName("info")));
				scbean.setProduct_skiclothimg(Fileutil.rename(multi.getFilesystemName("img")));
				SkiDAO sdao = new SkiDAO();
				//주문 현황을 저장
				sdao.insertskiclothAdd(scbean);
				RequestDispatcher dis =request.getRequestDispatcher("SkiClothListController.do");
				dis.forward(request, response);
		   }else if(multi.getParameter("ski").equals("board")){
			   String product_boardimg = multi.getFilesystemName("img");
			    String product_boardinfo=multi.getFilesystemName("info");
			    BoardListBean bbean = new BoardListBean();
			   
			    
				bbean.setProduct_boardno(Integer.parseInt(multi.getParameter("no")));

				bbean.setProduct_boardname(multi.getParameter("name")); 
				bbean.setProduct_boardprice(Integer.parseInt(multi.getParameter("price"))); 
				bbean.setProduct_boardinfo(Fileutil.rename(multi.getFilesystemName("info")));
				bbean.setProduct_boardimg(Fileutil.rename(multi.getFilesystemName("img")));
				BoardDAO ddao = new BoardDAO();
				//주문 현황을 저장
				ddao.insertboardAdd(bbean);
				RequestDispatcher dis =request.getRequestDispatcher("BoardListController.do");
				dis.forward(request, response);
		   }else if(multi.getParameter("ski").equals("boardcloth")){
			   String product_boardclothimg = multi.getFilesystemName("img");
			    String product_boardclothinfo=multi.getFilesystemName("info");
			    BoardClothListBean bcbean = new BoardClothListBean();
			   
			    
				bcbean.setProduct_boardclothno(Integer.parseInt(multi.getParameter("no")));

				bcbean.setProduct_boardclothname(multi.getParameter("name")); 
				bcbean.setProduct_boardclothprice(Integer.parseInt(multi.getParameter("price"))); 
				bcbean.setProduct_boardclothinfo(Fileutil.rename(multi.getFilesystemName("info")));
				bcbean.setProduct_boardclothimg(Fileutil.rename(multi.getFilesystemName("img")));
				BoardDAO ddao = new BoardDAO();
				//주문 현황을 저장
				ddao.insertboardclothAdd(bcbean);
				RequestDispatcher dis =request.getRequestDispatcher("BoardClothListController.do");
				dis.forward(request, response);
		   }
	}

}
