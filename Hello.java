import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		try{ 
			//CLASSPATH="C:\\Users\\shikh\\Downloads\\Microsoft JDBC Driver 6.0 for SQL Server\\sqljdbc_6.0\\enu\\jre8\\sqljdbc42.jar";
			
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		    
		  String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=shikherdatabase";
		    
		    //String dbURL="jdbc:sqlserver://localhost:62211;databaseName=carpool;integratedSecurity=true;";
		    Connection con = DriverManager.getConnection(dbURL);
		    if (con != null) {
		        System.out.println("Connected");
		    }
		    Statement stmt=con.createStatement(); 
		    ResultSet rs=stmt.executeQuery("select email from signup_info");
		    while(rs.next())
		     out.println(rs.getString("email"));
			  //out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		    con.close();  
		    }catch(Exception e){ System.out.println(e);}  
		    }  
	}
