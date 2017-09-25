package review.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class BbsCommand implements Command {

	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int pageNumber = 1;
		String review_Title = null;
		BbsDAO dao = new BbsDAO();
		if(request.getParameter("pageNumber") !=null){
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		
		if(review_Title == null){
		ArrayList<BbsVO> list = dao.getList(pageNumber);
		request.setAttribute("list", list);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageCount", dao.pageingCount());
		}
		if(request.getParameter("review_Title") !=null){
		review_Title = request.getParameter("review_Title");
		ArrayList<BbsVO> list = dao.getList(pageNumber,review_Title);
		request.setAttribute("list", list);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageCount", dao.pageingCount(review_Title));
		}
	}

}
