

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

/**
 * Servlet implementation class Inst1
 */
@WebServlet("/Inst1")
public class Inst1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		String id=(String) s.getAttribute("k1");
		if(id==null)
		{
			response.sendRedirect("index.jsp");
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps= con.prepareStatement("select * from loan where approval=?");
			ps.setString(1, "yes");
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.setContentType("html");
				out.println("<html><head><title>Loan Installment</title></head>");
				out.println("<body><h1 align=center>Loan Installment </h1>");
				do
				{
					out.println("<table border=1>");
					out.println("<tr><col width=4%><col width=6%><col width=3%><col width=5%><col width=4%><col width=4%><col width=6%>");
					out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>");
					out.println("<td><a href=Inst2?id="+rs.getString(1)+"><h3>Get Installment</h3></a></td>");
					out.println("</table>");
				}while(rs.next());
				
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
