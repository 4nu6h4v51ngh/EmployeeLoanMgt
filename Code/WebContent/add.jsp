
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

<h1 align="center">ADD NEW EMPLOYEE</h1><br>
<form action="Add">
<table align="center" cellpadding="5">
<tr><td>USER ID</td><td><input type="text" name="id"></td></tr>
<tr><td>NAME</td><td><input type="text" name="name"></td></tr>
<tr><td>EMAIL ID</td><td><input type="text" name="email"></td></tr>
<tr><td >BLOOD GROUP</td><td>
<select name="blood"><option>-</option>
<option>A+</option><option>A-</option>
<option>B+</option><option>B-</option>
<option>O+</option><option>O-</option>
<option>AB+</option><option>AB-</option>
</select>
</td></tr>
<tr><td >NEW PASSWORD</td><td><input type="password" name="pwd"></td></tr>

<tr><td>SALARY</td><td><input type="text" name="salary" ></td></tr>
<tr><td>ACCOUNT BALANCE</td><td><input type="text" name="balance" ></td></tr>
<tr><td>SECURITY QUESTION</td><td>
<select><option>   -    </option>
<option>Who is your favourite actor?</option>
<option>What's your first pet name ?</option>
<option>What's your nick name ?</option>
<option>Who is your best friend ?</option>
</select>
</td></tr>
<tr><td>ANSWER</td><td><input type="text" name="ans"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Go" ></td></tr>
</table>
</form>
</body>
</html>
