package review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDTO;
import review.bbs.BbsDAO;

@WebServlet("/commentSubmitServlet")
public class CommentSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String review_comment_content = URLDecoder.decode(request.getParameter("review_comment_content"),"UTF-8");
		int review_ID = Integer.parseInt(URLDecoder.decode(request.getParameter("review_ID"),"UTF-8"));
		String member_ID = URLDecoder.decode(request.getParameter("member_ID"),"UTF-8");
		String member_Image = null;
		
		try {
			RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
			member_Image = dto.getMember_img();
		} catch (Exception e) {
			member_Image = null;
		}
		
		if(review_comment_content ==null || review_comment_content.equals("")|| member_ID == null || member_ID.equals("")|| member_Image == null || member_Image.equals("")){
			response.getWriter().write("0");
		}
		else{
			response.getWriter().write(new BbsDAO().commentWrite(review_ID, member_ID, review_comment_content, member_Image)+"");
		}
		
	}

}
