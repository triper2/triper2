package business.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.AllBusinessListService;
import business.service.MyBusinessListService;
import business.service.Service;
import business.vo.BusinessVO;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;
import kosta.rental.loginModel.RentalDTO;
import netscape.javascript.JSObject;

@WebServlet("/_business/allList.business")
public class AllBusinessListControler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dp = null;
		AllBusinessListService command = null;
		
		command = new AllBusinessListService();
		command.execute(request,response);
		
		int size = command.getList().size();
		
		String str = "[";
		
		for(int i=0; i<size; i++) {
			str += "{\"place_name\":\""+ command.getList().get(i).getBusiness_name()
					+ "\", \"address_name\":\"" + command.getList().get(i).getBusiness_address()
					+ "\", \"road_address_name\":\"" + command.getList().get(i).getBusiness_road_address()
					+ "\", \"phone\":\"" + command.getList().get(i).getBusiness_tel()
					+ "\", \"x\":\"" + command.getList().get(i).getBusiness_x()
					+ "\", \"y\":\"" + command.getList().get(i).getBusiness_y()
					+ "\", \"id\":\"" + command.getList().get(i).getBusiness_id()
					+ "\"}";
			if(i!=size-1) str+=",";
		}
		
		str +="]";
		
		
		response.getWriter().print(str);
		
		
		/*request.setAttribute("list", command.getList());
		
		String viewPage="/_business/businessAllListForm.jsp";
		
		dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);*/
		
	}

}