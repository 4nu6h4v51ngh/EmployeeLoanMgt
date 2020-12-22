
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body>
<%@ include file="db.jsp" %>
<%
String id=(String) session.getAttribute("k1");
if(id==null)
{
response.sendRedirect("index.jsp");	
}
%>

<h1 align="center"> Welcome Sir</h1><br><a href="Logout"><h3 align="right">Logout</h3></a><hr>
<a href="add.jsp"><h3>Add Employee Record</h3></a>
<a href="EditEmp"><h3>Edit Employee Record</h3></a>
<a href="for1.jsp"><h3>Update Password</h3></a>
<a href="Loan2"><h3>Loan Request</h3></a>
<a href=Inst1><h3>Loan Installment</h3></a>
</body>
</html>
