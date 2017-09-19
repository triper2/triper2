<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "com.dao.AlbumDao" %>
<%@ page import = "com.domain.Album" %>
<html>
<head>
<title>юл╧лаЖ</title>
</head>
<%
   int service_id = Integer.parseInt(request.getParameter("service_id"));

      AlbumDao dbPro = AlbumDao.getInstance();
      Album article =  dbPro.getArticle(service_id);
%>
<body leftmargin="0" topmargin="0">
<table width="100%" border="0">
<tr>
  <td align="center"><a href="javascript:self.close()"><img src="./faq/service/upload/${album.service_img}" border="0" />
</a></td>
  </tr>
  </table>
</body>
</html>      
