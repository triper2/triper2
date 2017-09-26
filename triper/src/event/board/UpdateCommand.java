package event.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String getID = request.getParameter("ebNum");
		int ebNum = Integer.parseInt(getID);
		try {
			EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
			request.setAttribute("ebdto", ebdto);
			request.setAttribute("ebNum", ebNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
