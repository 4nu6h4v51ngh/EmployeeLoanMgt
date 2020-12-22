

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


@WebServlet("/Inst2")
public class Inst2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		String id=(String) s.getAttribute("k1");
		String idh=request.getParameter("id");
		int count=0;
		if(id==null)
		{
			response.sendRedirect("index.jsp");
		}
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","9893");
			java.sql.PreparedStatement ps=con.prepareStatement("select * from loan where id=?");
			ps.setString(1, idh);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int inst=rs.getInt(4);
				int tloan=rs.getInt(8);
				int tloan1=tloan-inst;
				if(tloan>0)
				{
				count=count+1;
				java.sql.PreparedStatement ps1=con.prepareStatement("update loan set tloan=?,count=? where id=?");
				
				ps1.setInt(1, tloan1);
				ps1.setInt(2, count);
				ps1.setString(3, idh);
				int x=0;
				x=ps1.executeUpdate();
				if(x!=0)
				{
					out.println("Successfully Installment paid");
				}
				else
				{
					out.println("not enough balance");
				}
				}
				else
				{
					out.println("loan of the customer is fulfilled");
				}
			}
			
		}catch (Exception e) {
			out.println(e);
		}
		
		
		
	}

}
