

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Loanapp")
public class Loanapp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("k2");
		PrintWriter out=response.getWriter();
		
		if(id==null)
		{
		response.sendRedirect("index.jsp");	
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps=con.prepareStatement("select * from emp where id=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String name=rs.getString(3);
				response.setContentType("html");
				out.println("<html>");
				out.println("<head><title>Loan Appliction</title></head><body>");
				
				out.println("<h1 align=\"center\">Loan Chart</h1>");
				
				out.println("<table border=\"1\" align=\"center\" cellpadding=7>");
				out.println("<tr><th>Loan Type</th><th>Rate Of interest</th><th>Monthly Installment</th></tr>");
				out.println("<tr><td>Home Loan</td><td>8% per annum</td><td>3000</td></tr>");
				out.println("<tr><td>Education Loan</td><td>11% per annum</td><td>2500</td></tr>");
				out.println("<tr><td>Car Loan</td><td>10% per annum</td><td>3500</td></tr>");
				out.println("<tr><td>Buissness Loan</td><td>12% per annum</td><td>4000</td></tr>");
				out.println("<tr><td>Appliance Loan</td><td>7% per annum</td><td>2500</td></tr>");
				out.println("<tr><td>Personal Loan</td><td>6% per annum</td><td>3000</td></tr>");
				out.println("</table>");
				
				out.println("<h1 align=center>Employee Loan Application</h1>");
				out.println("<h2 align=center style=\"color: red\">Loan amount never less than 50000</h2>");
				out.println("<form action=Loan1><table align=center cellpadding=7>");
				out.println("<tr><td>User Id</td><td><input type=text name=id value="+id+" readonly></td></tr>");
				out.println("<tr><td>Applicant Name</td><td><input type=text name=name value="+name+" readonly></td></tr>");
				out.println("<tr><td>Monthly Salary</td><td><input type=text name=salary value="+rs.getString(5)+" readonly></td></tr>");
				out.println("<tr><td>Loan Type</td><td><select name=loantype><option>Select One </option>");
				
				out.println("<option>Home Loan </option>");
				out.println("<option>Car Loan </option>");
				out.println("<option>Education Loan </option>");
				out.println("<option>Buissness Loan </option>");
				out.println("<option>Appliance Loan </option>");
				out.println("<option>Personal Loan </option></select></td></tr>");
				out.println("<tr><td>Loan Amount</td><td><input type=text name=loanamt></td></tr>");
				out.println("<tr><td colspan=2 align=center><input type=submit value=go></td></tr>");
				out.println("</form>");
				out.println("");
				out.println("");
				out.println("");
				out.println("");
				out.println("");
				out.println("</html>");
				
			}
			
		}
		catch (Exception e) {
			out.println(e);
		}
		
		
	}

}
