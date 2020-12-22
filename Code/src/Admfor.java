

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


@WebServlet("/Admfor")
public class Admfor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=request.getParameter("id");
		String ans=request.getParameter("ans");
		PrintWriter out=response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps=con.prepareStatement("select * from admin where id=? and ans=?");
			ps.setString(1, id);
			ps.setString(2, ans);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("for1.jsp");
				
			}
			else
			{
				out.println("not registered");
			}
			con.close();
		}catch(Exception e)
			{
				out.println(e);
			}
	}

}
