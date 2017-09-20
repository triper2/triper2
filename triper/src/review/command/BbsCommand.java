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
		if(request.getParameter("pageNumber") !=null){
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		String member_ID = String.valueOf(request.getSession().getAttribute("member_id"));
		System.out.println(member_ID);
		BbsDAO dao = new BbsDAO();
		
		ArrayList<BbsVO> list = dao.getList(pageNumber);
		
		
		request.setAttribute("list", list);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("pageCount", dao.pageingCount());
		request.setAttribute("member_ID", member_ID);
		
	}

}
