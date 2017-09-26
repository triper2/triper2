/*package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDTO;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class LikeHateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int review_ID=Integer.parseInt(request.getParameter("review_ID"));
		String member_id=null;
		
		
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
				script.println("location.href = 'bbs.review'");
				script.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else{
			BbsDAO dao = new BbsDAO();
			BbsVO bbs = new BbsDAO().getBbs(review_ID);
			if(like != null){
				dao.likeUpdate(bbs.getReview_Like(), review_ID);
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'view.review?review_ID="+review_ID+"'");// 로그인 페이지
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (hate != null){
				dao.hateUpdate(bbs.getReview_Hate(), review_ID);
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'view.review?review_ID="+review_ID+"'");// 로그인 페이지
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("location.href = 'view.review?review_ID="+review_ID+"'");// 로그인 페이지
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
*/