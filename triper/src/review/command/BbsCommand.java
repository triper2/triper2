package review.command;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class BbsCommand implements Command {

	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

	
		String pageNumber = request.getParameter("pageNumber");
		String member_ID ="123";
		
		if(pageNumber ==null)pageNumber="1";
		int pageNum = Integer.parseInt(pageNumber);
		
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> list = dao.getList(pageNum);
		
		
		request.setAttribute("list", list);
		request.setAttribute("member_ID", member_ID);

	}

}
