<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>
<%@ include file="db.jsp" %>
<%

	try
	{

		PreparedStatement ps=con.prepareStatement("select * from emp");
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			do
			{
				response.setContentType("html/text");
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 align=center> </h1><br>");
				out.println("<table cellpadding=5><tr><th>ID</th><th>NAME</th><th>SALARY</th><th>EDIT</th><th>DELETE</th</tr>");
				out.println("<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</td><td>"+rs.getString("salary")+"</td><td><a href=>S#</a></td><td><a href=>S!</a></td></tr>");
				out.println("<html>");
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
				
				
			}while(rs.next());
		}
		else
		{
			out.println("not registered");
		}
		con.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
%>
</head>
<body>

</body>
</html>
