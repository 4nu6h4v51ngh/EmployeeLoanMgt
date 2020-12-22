

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


@WebServlet("/Edit2")
public class Edit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		String id=(String) s.getAttribute("k2");
		if(id==null)
		{
			response.sendRedirect("index.jsp");
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps= con.prepareStatement("select * from emp where id=?");
			ps.setString(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.setContentType("html");
				out.println("<html><head><title>Edit Employee Profile</title></head>");
				out.println("<body>");
				out.println("<h1 align=center>Employee Information  </h1><br>");
				
				
					String s1=rs.getString(1);
					String s3=rs.getString(3);
					String s5=rs.getString(5);
					String s2=rs.getString(2);
					String s4=rs.getString(4);
					out.println("<form action=S4>");
					out.println("<h2  style=\"color: red\" align=center>Information entered here will be edited in the database</h2>");
					out.println("<table cellpadding=8  border=1 align=center>");
					
					out.println("<tr><td>USER ID</td><td><input type=text value="+s1+" name=id readonly></td></tr>");
					out.println("<tr><td>NAME</td><td><input type=text name=name value="+s3+"></td></tr>");
					out.println("<tr><td>PASSWORD</td><td><input type=text name=pwd value="+s2+"></td></tr>");
					out.println("<tr><td>SALARY</td><td><input type=text name=salary value="+s5+" readonly></td></tr>");
					out.println("<tr><td>SECURITY ANSWER</td><td><input type=text name=ans value="+s4+"></td></tr>");
					
					out.println("<tr><td colspan=2 align=center><input type=submit value=submit></td></tr>");
					
					out.println("</table>");
					
					out.println("</form>");
					out.println("</body>");
					out.println("</html>");
					
					
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
		
		
		
	}

}
