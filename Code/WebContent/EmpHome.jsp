
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home Page</title>
</head>
<body>
<%@ include file="db.jsp" %>
<%
String id=(String) session.getAttribute("k2");
if(id==null)
{
response.sendRedirect("index.jsp");	
}
%>

<h1 align="center"> Welcome Sir</h1><br><a href="Logout"><h3 align="right">Logout</h3></a><hr>
<a href="Edit2"><h3>Edit Profile</h3></a>
<a href="for2.jsp"><h3>Update Password</h3></a>
<a href="Loanapp"><h3>Loan Application</h3></a>
<a href="LoanStatus"><h3>Loan Status</h3></a>

</body>
</html>
