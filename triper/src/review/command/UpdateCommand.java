package review.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String getID = request.getParameter("review_ID");
		int review_ID = Integer.parseInt(getID);
		BbsVO bbs = new BbsDAO().getBbs(review_ID);
		request.setAttribute("bbs", bbs);
	}
}
