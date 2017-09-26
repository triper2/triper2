package event.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.rental.loginModel.RentalDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

			String getID = request.getParameter("ebNum");
			String member_id = null;
						
			try {
				RentalDTO dto = (RentalDTO)request.getSession().getAttribute("dto");
				member_id = dto.getMember_id();
			} catch (Exception e) {
				member_id = null;
			}
			
			int ebNum = Integer.parseInt(getID);
			if (ebNum == 0) { //번호가 꼭있어야 출력가능함
				PrintWriter script;
				try {
					script = response.getWriter();
					script.println("<script>");
					script.println("alert('유효하지 않은 글입니다')");
					script.println("location.href = 'bbs.review'"); //로그인 페이지
					script.println("</script>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
			try {
				EboardDTO ebdto = new EboardDAO().getEboardDTO(ebNum);
				request.setAttribute("ebdto", ebdto);
				request.setAttribute("ebNum", ebNum);
				request.setAttribute("member_id", member_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}



