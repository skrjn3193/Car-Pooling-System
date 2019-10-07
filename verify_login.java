import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class verify_login
 */
@WebServlet("/verify_login")
public class verify_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   static String uid;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		PrintWriter out=response.getWriter();
		uid =request.getParameter("uid");
		String pass=request.getParameter("psw");
		HttpSession session=request.getSession();
		session.setAttribute("empid", uid);
	
		//request.getRequestDispatcher("HomePage.html").include(request, response);
		try{ 	
			Class.forName("com.mysql.jdbc.Driver");  
		    String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
		    Connection con = DriverManager.getConnection(dbURL);
		    if (con != null) {
		        System.out.println("Connected");
		    }
			    Statement stmt=con.createStatement(); 
			    ResultSet rs=stmt.executeQuery("select * from signup_info where empid='"+uid+"' and user_password='"+pass+"'");
			    int count=0;
				 while(rs.next())
					 count++;
				 if(count>0) {
					 Cookie ck=new Cookie("name",uid);
					  response.addCookie(ck);
					  response.sendRedirect("HomePage.html");
					  } 
				 else {
					 out.println("<script type=\"text/javascript\">");
					 out.println("alert('Invalid Username or Password');");
					 out.println("</script>"); 
					 out.flush();
					 RequestDispatcher rd=request.getRequestDispatcher("index.html");
					 rd.forward(request, response); 
				 }
			    con.close();  
			    }catch(Exception e){ System.out.println(e);}
		
		}
}
	
	/*
//		 * if(uid.equals(uid1) && pwd.equals(pass)) { Cookie ck=new Cookie("name",uid);
//		 * response.addCookie(ck);
//		 * request.getRequestDispatcher("HomePage.html").forward(request, response); }
//		 * else { response.setContentType("text/html");
//		 * out.println("<script type=\"text/javascript\">");
//		 * out.println("alert('Invalid Username or Password');");
//		 * out.println("</script>"); out.flush(); RequestDispatcher
//		 * rd=request.getRequestDispatcher("index.html"); rd.include(request, response);
//		 * 
//		 * }
//		 */
//		
//}	
//
//package basic;
//
//import java.sql.*;  
//class DemoClass{  
//public static void main(String args[]){  
//try{  
//Class.forName("com.mysql.jdbc.Driver");  
//String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
//Connection con = DriverManager.getConnection(dbURL);
//if (con != null) {
//    System.out.println("Connected");
//}
//Statement stmt=con.createStatement(); 
//ResultSet rs=stmt.executeQuery("select * from signup_info");  
//while(rs.next())
//		System.out.println(rs.getString("username"));
//con.close();  
//}
//catch(Exception e)
//	{ 
//	System.out.println(e);
//	}  


