

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.io.PrintWriter;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class post_ride
 */
@WebServlet("/post_ride")
public class post_ride extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init() throws ServletException {

		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();	

	String loc= request.getParameter("loc");
	String timetoleave= request.getParameter("timetoleave");
	String typeofvehicle= request.getParameter("typeofvehicle");
	String noofseats= request.getParameter("noofseats");
	String selectroute=request.getParameter("route");
	HttpSession session=request.getSession();
	String empid=(String) session.getAttribute("empid");
	
    	request.getRequestDispatcher("HomePage.html").include(request, response);  
	
	
	try{ 
		 
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		  String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
		  Connection con = DriverManager.getConnection(dbURL);
		   if (con != null) {
			   
		   }
		    Statement stmt=con.createStatement(); 
		    stmt.executeUpdate("insert into postride_details(Empid,Landmark,TimetoLeave,TypeofVehicle,Noofseats,Selectroute) values('"+empid+"','"+loc+"', '"+timetoleave+"','"+typeofvehicle+"','"+noofseats+"','"+selectroute+"')");
			con.close();  
		    }catch(Exception e){ System.out.println(e);}
		
	}

}
