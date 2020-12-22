

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

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/S1")
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
	
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps=con.prepareStatement("update admin set pwd=? where id=?");
			ps.setString(1, pwd);
			ps.setString(2, id);
			int x=0;
			x=ps.executeUpdate();
			if(x!=0)
			{
				response.sendRedirect("AdminLog.jsp");
			}
			else
			{
				out.println("wrong id ");
			}
			
		}catch (Exception e) {
			out.println("exception "+e);
		}
		
	}

}
