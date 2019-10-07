

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Store_new_user_data
 */
@WebServlet("/Store_new_user_data")
public class Store_new_user_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();	
		
		String empname=request.getParameter("username");
		String empemail=request.getParameter("email");
		String empid=request.getParameter("empid");
		String psd=request.getParameter("psd");
		try{ 	
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		  String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
		  Connection con = DriverManager.getConnection(dbURL);
		   if (con != null) {
			   System.out.println("Connected");
		    }
		    Statement stmt=con.createStatement(); 
		    stmt.executeUpdate("insert into signup_info values('"+empid+"','"+empemail+"', '"+empname+"','"+psd+"')");
			/*
			 * while(rs.next()) out.println(rs.getString("email"));
			 */
		    con.close();  
		    }catch(Exception e){ System.out.println(e);}
		
		response.setContentType("text/html");
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Signup Successful.! Login Again');");
		out.println("</script>");
		out.flush();
		request.getRequestDispatcher("index.html").include(request, response);
		}
	}
