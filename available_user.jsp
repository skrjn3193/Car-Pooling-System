<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
table,th,tr,td{
border:2px solid blue;

}  </style>
</head>
<body>

<div class="container">
<h2 style="text-align:center">Available Cars Details</h2>
<br>
  <div class="table-responsive">          
  <table class="table">
    <thead>
      <tr>
        <th>Employee Id</th>
        <th>Area</th>
        <th>Location</th>
        <th>Time To Pickup</th>
        <th>No of Seats</th>
        <th>Accept</th>
      </tr>
    </thead>
    <tbody>
     
      <%
      try{ 
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		  String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193";
		  Connection con = DriverManager.getConnection(dbURL);
		  Statement stmt=con.createStatement(); 
		  ResultSet rs=stmt.executeQuery("select * from requestride_participant where SystemDate =(SELECT Convert(varchar(10), GETDATE(),120))");
		  while(rs.next())
		  { 
		  %>
		  <tr>
		    <td><%=rs.getString("empid")%></td>
		    <td><%=rs.getString("area") %></td>
		    <td><%=rs.getString("location_p") %></td>
		    <td><%=rs.getString("timetopickup") %></td>
		    <td><%=rs.getString("noofseats_p") %></td>
		    <td><a href="http://localhost:8080/CarPooling/available_user.jsp?id=<%out.println(rs.getString("ID"));%>">Yes</a></td>
		    </tr>
		          <%
		  }
		  %>
		   <%
    rs.close();
    stmt.close();
    con.close();
    }
      catch(Exception e)	
      		{
    	  		System.out.println(e);
    	  	}
      
      %>
    </tbody>
  </table>
  </div>
</div>

</body>
</html>
