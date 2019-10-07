<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.title {
  color: grey;
  font-size: 18px;
}

#button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}


</style>
</head>
<body>

/<%
      try{ 
    	  HttpSession s=request.getSession();
  		  String empid=(String) s.getAttribute("empid");
    	 // out.println(empid);
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		  String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=shikherdatabase";
		  Connection con = DriverManager.getConnection(dbURL);
		  Statement stmt=con.createStatement(); 
		  ResultSet rs=stmt.executeQuery("select * from profiledetails where Empid='"+empid+"'");
		  while(rs.next()){
			  %>
			<h2 style="text-align:center">User <%=rs.getString("Empid") %>'s Profile</h2>
			<div class="card">
  			<img src="http://www.letuspublish.com/wp-content/uploads/2017/04/Virat-Kohli-wallpaper.jpg" alt="Kohli" style="width:100%">
  			<h1><%=rs.getString("Fullname")%></h1>
			<p class="title"><%=rs.getString("Email") %></p>
 			<p><b>Address:</b><%=rs.getString("Adress")%> <b>City:</b> <%=rs.getString("City") %></p>
 			<p><b>Zipcode</b><%=rs.getString("ZipCode")%></p>
  			<p><b>Vehicle No. </b><%=rs.getString("VehicleNo") %></p>
  			<p id="button"><b>Contact no. </b><%=rs.getString("ContactNo") %></p>
</div>
			  
		<%  
		}
		  
      }
	catch(Exception e)	
	{
		System.out.println(e);
	}
%>	 

</body>
</html>
