package review.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int review_ID = Integer.parseInt(URLDecoder.decode(request.getParameter("review_ID"),"UTF-8"));
		String listType = request.getParameter("listType");

		if(listType == null || listType.equals("")){
			response.getWriter().write("");
		}
		else if(listType.equals("today")) response.getWriter().write(getToday(review_ID));
	}
	
	private String getToday(int review_ID) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		BbsDAO BbsDAO = new BbsDAO();
		ArrayList<BbsVO> commentList = BbsDAO.getComment(review_ID);
		for(int i =0; i<commentList.size();i++){
			result.append("[{\"value\": \"" + commentList.get(i).getMember_ID()+"\"},");
			result.append("{\"value\": \"" + commentList.get(i).getReview_comment_content()+"\"},");
			result.append("{\"value\": \"" + commentList.get(i).getReview_comment_date()+"\"}]");
			if(i !=commentList.size() - 1)result.append(",");
		}
		result.append("], \"last\":\""+commentList.get(commentList.size()-1).getMember_ID()+"\"}");
		return result.toString();
	}
}
