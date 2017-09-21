package review.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDTO;

public class LikeHateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String like = request.getParameter("like");
		String hate = request.getParameter("hate");
		String review_ID=request.getParameter("review_ID");
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
			
			if(like != null){
				
				
			}
			else if (hate != null){
				
				
			}
			
			
			
			System.out.println(like);
			System.out.println(hate);
			System.out.println(review_ID);
		}

	}

}
