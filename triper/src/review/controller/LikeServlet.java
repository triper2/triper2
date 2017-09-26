package review.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDTO;
import review.bbs.BbsDAO;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int review_ID = Integer.parseInt(URLDecoder.decode(request.getParameter("review_ID"),"UTF-8"));
		String member_ID = URLDecoder.decode(request.getParameter("member_ID"),"UTF-8");
		
		try {
			RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
			member_ID = dto.getMember_id();
		} catch (Exception e) {
			member_ID = null;
		}
		
		if(new BbsDAO().likeUpdate(member_ID, review_ID)==0){
			if(member_ID == null || member_ID.equals("")){
				response.getWriter().write("0");
			}
			else{
				System.out.println("좋아요");
				response.getWriter().write(new BbsDAO().liketable(member_ID, review_ID)+"");
			}
		}
		else{
			if(member_ID == null || member_ID.equals("")){
				response.getWriter().write("0");
			}
			else{
				System.out.println("싫어요");
				response.getWriter().write(new BbsDAO().hateUpdate(member_ID, review_ID)+"");
			}
		}
	}

}
