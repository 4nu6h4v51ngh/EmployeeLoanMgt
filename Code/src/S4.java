

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/S4")
public class S4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String salary=request.getParameter("salary");
		String ans=request.getParameter("ans");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps= con.prepareStatement("update emp set pwd=?,name=?,ans=? where id=?");
			ps.setString(1, pwd);
			ps.setString(2, name);
			
			ps.setString(3, ans);
			ps.setString(4, id);
			int x=0;
			x=ps.executeUpdate();
			if(x!=0)
			{
				response.sendRedirect("EmpHome.jsp");
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
