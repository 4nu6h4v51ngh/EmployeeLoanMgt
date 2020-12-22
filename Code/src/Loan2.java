

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


@WebServlet("/Loan2")
public class Loan2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession s=request.getSession();
		String id=(String) s.getAttribute("k1");
		PrintWriter out=response.getWriter();
		
		if(id==null)
		{
			response.sendRedirect("index.jsp");
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps= con.prepareStatement("select * from loan");
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.setContentType("html");
				out.println("<html><head><title>Loan Request</title></head>");
				out.println("<body>");
				out.println("<h1 align=center>Loan Request Table  </h1><br>");
				
				do
				{
					out.println("<table cellpadding=8  border=1>");
					out.println("<tr><col width=7%><col width=14%><col width=6%><col width=10%><col width=15%><col width=15%>");
					out.println("<td>"+rs.getString(1)+"</td><td >"+rs.getString(2)+"</td><td >"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5));
					out.println("</td><td>"+rs.getString(6)+"</td><td><a href=Accept?idh="+rs.getString(1)+">Accept Loan</a></td><td><a href=Reject?idh="+rs.getString(1)+">Reject Loan</a></td></tr>");					
					out.println("</table>");
					out.println("</body>");
					out.println("</html>");
				}while(rs.next());
			}
		}catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
