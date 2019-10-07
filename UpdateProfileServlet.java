

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		
		String fullname=request.getParameter("fullName");
		String address=request.getParameter("addressLine1");
		String postcode=request.getParameter("postcode");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String email=request.getParameter("email");
		String phonenumber=request.getParameter("phoneNumber");
		//InputStream profile = new FileInputStream(request.getParameter("profileimage"));
		String vehicleno=request.getParameter("vehicleno");
		//InputStream driving = new FileInputStream(request.getParameter("drivinglicence"));
		
		HttpSession session=request.getSession();
		String empid=(String) session.getAttribute("empid");

		try{
			 
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
			 String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
			 
			 Connection con = DriverManager.getConnection(dbURL);
			 
			 Statement stmt=con.createStatement();
			 stmt.executeUpdate("insert into profiledetails(Empid,Fullname,Email,ContactNo,Adress,ZipCode,City,States,VehicleNo) values('"+empid+"','"+fullname+"','"+email+"','"+phonenumber+"','"+address+"','"+postcode+"','"+city+"','"+state+"','"+vehicleno+"')");
			 con.close(); 
			 }
			 catch(Exception e)
			 { 
				 System.out.println(e);
			 }
			
		response.sendRedirect("HomePage.html");

	}
}
