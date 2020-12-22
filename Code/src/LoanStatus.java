

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


@WebServlet("/LoanStatus")
public class LoanStatus extends HttpServlet {
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
			java.sql.PreparedStatement ps=con.prepareStatement("select * from loan where id=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String app=rs.getString(7);
				if(app.equals("yes"))
				{
					response.setContentType("html");
					out.println("<html><head><title>Loan Status</title></head>");
					out.println("<body><h1 align=center>Loan Status</h1><br>");
					out.println("<table align=center border=1 cellpadding=7>");
					out.println("<tr><td>ID</td><td>"+rs.getString(1)+"</td></tr>");
					out.println("<tr><td>NAME</td><td>"+rs.getString(6)+"</td></tr>");
					out.println("<tr><td>LOAN AMOUNT</td><td>"+rs.getString(2)+"</td></tr>");
					out.println("<tr><td>REMAINING LOAN</td><td>"+rs.getString(8)+"</td></tr>");
					out.println("<tr><td>LOAN TYPE</td><td>"+rs.getString(5)+"</td></tr>");
					out.println("<tr><td>MONTHLY INSTALLMENT</td><td>"+rs.getString(2)+"</td></tr>");
					out.println("<tr><td>ROI</td><td>"+rs.getString(3)+"%</td></tr>");
					out.println("<tr><td>APPROVAL STATE</td><td>"+rs.getString(7)+"</td></tr>");
					out.println("<tr><td>INSTALLMENT COUNT</td><td>"+rs.getString(9)+"</td></tr>");
					out.println("</table>");
					out.println("</body></html>");
				}
				
			}
			else {
				out.println("you don't applied for any type of loan ");
			}
			
		}catch (Exception e) {
			out.println(e);
		}
		
		
	}

}
