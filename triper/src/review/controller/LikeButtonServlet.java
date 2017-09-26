package review.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.bbs.BbsDAO;

/**
 * Servlet implementation class LikeButtonServlet
 */
@WebServlet("/LikeButtonServlet")
public class LikeButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int review_ID = Integer.parseInt(URLDecoder.decode(request.getParameter("review_ID"),"UTF-8"));
		String member_ID = URLDecoder.decode(request.getParameter("member_ID"),"UTF-8");
		response.getWriter().write(new BbsDAO().likeUpdate(member_ID, review_ID)+"");
		
		
	}

}
