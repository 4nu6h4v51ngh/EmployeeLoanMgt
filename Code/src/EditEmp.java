

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

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/EditEmp")
public class EditEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("k1");
		if(id==null)
		{
		response.sendRedirect("index.jsp");	
		}
		
		PrintWriter out=response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps= con.prepareStatement("select * from emp");
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.setContentType("html");
				out.println("<html><head><title>Edit Employee Profile</title></head>");
				out.println("<body>");
				out.println("<h1 align=center>Employee Table  </h1><br>");
				int x=0;
				//out.println("<table cellpadding=8  border=1>");
				
				do
				{
					
					String s1=rs.getString(1);
					String s2=rs.getString(3);
					String s3=rs.getString(5);
					out.println("<table cellpadding=8  border=1>");
			
					out.println("<tr><col width=7%><col width=10%><col width=6%><col width=5%><col width=4%><col width=4%><col width=8%>");
					out.println("<td>"+s1+"</td><td>"+s2+"</td><td>"+s3+"</td><td>"+rs.getString(6)+"</td>");
					out.println("<td>"+rs.getString(7)+"</td><td><a href=Edit1?id="+s1+"><h3>Edit/View</h3></a></td>");
					out.println("<td><a href=Delete?id="+s1+"><h3>Delete</a></h3></td>");
					out.println("</tr>");
					
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
		
		
		
	}

	
	

}
