package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

			String getID = request.getParameter("review_ID");
			int review_ID = Integer.parseInt(getID);
			if (review_ID == 0) {//번호가 꼭있어야 출력가능함
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('유효하지 않은 글입니다')");
					script.println("location.href = 'bbs.review'");//로그인 페이지
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			BbsVO bbs = new BbsDAO().getBbs(review_ID);
			request.setAttribute("bbs", bbs);
			request.setAttribute("review_ID", review_ID);

	}

}
