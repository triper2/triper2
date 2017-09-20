package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.rental.loginModel.RentalDTO;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class UpdateActionCommand implements Command {
	HttpSession session = null;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String member_id = null;
		String review_Content = request.getParameter("review_Content");
		String review_Image_1 = null;
		
		
		
		try {
			review_Image_1 = review_Content.substring(review_Content.indexOf("<img src=")+10,review_Content.indexOf(">")-1);
		} catch (Exception e) {
			review_Image_1 = "/triper/image/test_1.jpg";
		}
		
		
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
		int review_ID = 0;
		if (request.getParameter("review_ID") != null) {
			
			review_ID = Integer.parseInt(request.getParameter("review_ID"));
		}
		
		
		BbsVO bbs = new BbsDAO().getBbs(review_ID);
		if (!member_id.equals(bbs.getMember_ID())) {
			PrintWriter script;
			try {
				script = response.getWriter();
				script.println("<script>");
				script.println("alert('권한이 없습니다.')");
				script.println("location.href='bbs.jsp'");
				script.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			if (request.getParameter("review_Title") == null || request.getParameter("review_Content") == null
					|| request.getParameter("review_Title").equals("") || request.getParameter("review_Content").equals("")) {
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('입력이 안 된 사항이 있습니다.')");
					script.println("history.back()");
					script.println("</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				BbsDAO bbsDAO = new BbsDAO();
				int result = bbsDAO.update(review_ID, request.getParameter("review_Title"),
						request.getParameter("review_Content"),review_Image_1);
				if (result == -1) {
					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("alert('글 수정이 실패했습니다')");
						script.println("history.back()");
						script.println("</script>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("location.href = 'bbs.review'");
						script.println("</script>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
			}
		}
	}
}
