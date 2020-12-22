
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="db.jsp" %>
<%
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");

try
{

	PreparedStatement ps=con.prepareStatement("select * from  emp where id=? and pwd=?");
	ps.setString(1, id);
	ps.setString(2, pwd);
	
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		session.setAttribute("k2", id);
		response.sendRedirect("EmpHome.jsp");
		//out.println("successfully login ");
	}
	else
	{
		out.println("not registered");
	}
	con.close();
}catch(Exception e)
	{
		out.println(e);
	}
%>
</body>
</html>
