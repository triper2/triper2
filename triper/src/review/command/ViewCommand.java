package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDTO;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

			String getID = request.getParameter("review_ID");
			String member_id = null;
			try {
				RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
				member_id = dto.getMember_id();
			} catch (Exception e) {
				member_id = null;
			}
			
			if (member_id == null) {
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('로그인을 하세요')");
					script.println("location.href = 'bbs.review'");// 로그인 페이지
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			
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
			
			int commentPageNumber = 1;
			if(request.getParameter("commentPageNumber") !=null){
				commentPageNumber = Integer.parseInt(request.getParameter("commentPageNumber"));
			}
			
			System.out.println(commentPageNumber);
			BbsDAO dao = new BbsDAO();
			request.setAttribute("commentPageNumber", commentPageNumber);
			request.setAttribute("commentPageCount", dao.commentPageingCount(review_ID));
			
			BbsVO bbs = new BbsDAO().getBbs(review_ID);
			request.setAttribute("bbs", bbs);
			request.setAttribute("review_ID", review_ID);
			request.setAttribute("member_ID", member_id);

	}

}



