

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
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
		String idh=request.getParameter("id");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps= con.prepareStatement("delete from emp where id=?");
			ps.setString(1, idh);
			int x=0;
			x=ps.executeUpdate();
			out.println("record deleted from the employee record table");
			
		}catch (Exception e) {
			out.println(e);
		}
		
		
	}

	
	

}
