package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.rental.loginModel.RentalDTO;
import review.bbs.BbsDAO;
import review.bbs.BbsVO;

public class WriteCommand implements Command {
	HttpSession session = null;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		String member_id = null;
		String review_Title =request.getParameter("review_Title");
		String review_Content = request.getParameter("review_Content");
		String member_image=null;
		String review_Image_1 = null;
		
		
		
		try {
			review_Image_1 = review_Content.substring(review_Content.indexOf("<img src=")+10,review_Content.indexOf(">")-1);
		} catch (Exception e) {
			review_Image_1 = "/triper/image/test_1.jpg";
		}
		
		
		try {
			RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
			member_id = dto.getMember_id();
			member_image = dto.getMember_img();
		} catch (Exception e) {
			member_id = null;
			member_image = null;
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

		} else {
			if (review_Title.equals("")|| review_Content.equals("")) {
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
				int result = bbsDAO.write(review_Title, member_id, review_Content, review_Image_1,member_image);
				if (result == -1) {
					PrintWriter script;
					try {
						script = response.getWriter();
						script.println("<script>");
						script.println("alert('글쓰기에 실패했습니다')");
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
						script.println("location.href = 'bbs.review?pageNumber=1'");// 로그인 페이지
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
