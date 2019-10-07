import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register_data extends HttpServlet {

	public static void main(String[] args) {
		 try{  
			    Class.forName("com.mysql.jdbc.Driver");  
			    String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
			    Connection con = DriverManager.getConnection(dbURL);
			    if (con != null) {
			        System.out.println("Connected");
			    }
			    //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/master","shikher","shikherdatabase");

			  
			    //here shikher is database name, shikherdatabase is  password  


			/*
			 * Statement stmt=con.createStatement(); ResultSet
			 * rs=stmt.executeQuery("select city from student2"); while(rs.next())
			 * System.out.println(rs.getString("city"));
			 * //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			 * con.close();
			 */
			    }
		 catch(Exception e)
		 { System.out.println(e);
		 }  
}  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();	
			
			String empname=request.getParameter("username");
			String empemail=request.getParameter("email");
			String empid=request.getParameter("empid");
			String psd=request.getParameter("psd");
			//String confirm_psd=request.getParameter("psw-repeat");
			
			out.println(empname);
			out.println(empemail);
			out.println(empid);
			out.println(psd);
	}

}
