

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



@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String ans=request.getParameter("ans");
		String salary=request.getParameter("salary");
		String email=request.getParameter("email");
		String blood=request.getParameter("blood");
		String balance=request.getParameter("balance");
		
		PrintWriter out=response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.setString(4, ans);
			ps.setString(5, salary);
			ps.setString(6, balance);
			ps.setString(7, blood);
			ps.setString(8, email);
			int x=0;
			x=ps.executeUpdate();
			if(x!=0)
			{
				response.sendRedirect("AdmHome.jsp");
				//out.println("inserted successfully");
			}
			else
			{
				out.println("not inserted");
			}
			
			con.close();
		}catch(Exception e)
			{
				out.println(e);
			}
		
		
	}

}
