<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
h1{
text-align:center;
}</style>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<table class="table">
<tbody>
<%
      try{ 
    	  HttpSession s=request.getSession();
  		  String empid=(String)s.getAttribute("empid");
  
  		  String id=request.getParameter("id");
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
		  String dbURL = "jdbc:sqlserver://localhost:62211;databaseName=carpool;user=shikher;password=skrjn3193	";
		  Connection con = DriverManager.getConnection(dbURL);
		  Statement stmt=con.createStatement();
		  ResultSet rs=stmt.executeQuery("select * from profiledetails where Empid=(select empid from postride_details where ID='"+id+"')");
		  while(rs.next()){	
		  %>
		  <h1><b>Your Driver Details are:</b></h1>
		  <div class="container">
		  <span><b>Name : </b></span><%=rs.getString("Fullname") %>
		  </div>
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
</body>
</html>