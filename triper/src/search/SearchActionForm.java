package search;

import search.SearchVo;
import search.SearchDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.SearchAction;

public class SearchActionForm implements SearchAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		 
		
		return "/_search/search.jsp";
	}

}


