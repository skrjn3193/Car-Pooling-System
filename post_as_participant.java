

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class post_as_participant
 */
@WebServlet("/post_as_participant")
public class post_as_participant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String loc_p= request.getParameter("loc_p");
		String area_p=request.getParameter("area_p");
		String timetoleave_p= request.getParameter("timetoleave_p");
		String noofseats_p= request.getParameter("noofseats_p");
		HttpSession session=request.getSession();
		String empid=(String) session.getAttribute("empid");
		response.sendRedirect("HomePage.html");
		
		 try{
		 
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		
		 String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
		 
		 Connection con = DriverManager.getConnection(dbURL);
		 
		 Statement stmt=con.createStatement();
		 
		 stmt.executeUpdate("insert into requestride_participant(empid,area,location_p,timetopickup,noofseats_p) values('"+empid+"','"+area_p+"', '"+loc_p+"','"+timetoleave_p+"','"+noofseats_p+"')");
		 con.close(); 
		 }
		 catch(Exception e)
		 { 
			 System.out.println(e);
		 }
		

		
	}
}
