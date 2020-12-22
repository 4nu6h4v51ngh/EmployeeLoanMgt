

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

@WebServlet("/Accept")
public class Accept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession s=request.getSession();
		String id=(String) s.getAttribute("k1");
		PrintWriter out=response.getWriter();
		String idh=request.getParameter("idh"); 
		
		
		if(id==null)
		{
			response.sendRedirect("index.jsp");
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps= con.prepareStatement("update loan set approval=? where id=?");
			
			ps.setString(1, "yes");
			ps.setString(2, idh);
			int x=0;
			x=ps.executeUpdate();
			if(x!=0)
			{
				out.println("successfully updated");
			}
			
		}catch (Exception e) {
			out.println(e);
		}
		
		
	}

}
