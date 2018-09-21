<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean.CircularBean" %>
    <%@ page import="java.sql.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#name{

background-color:rgb(192,192,192);opacity:0.6;
  background-size: cover;
}
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: red;
    color: white;
}
</style>
</head>
<body >
<div class="container">
<form id="name" class="form-inline"align="center" method="post" action="Circular">
<div>
<label >Date</label>
<input type="date" name="d">
</div>
<div>
<label>Circular name</label>
<input type="text" name="data">
</div>
<div>
<label>Description</label>
<input type="text" name="des">
</div>
<input type="submit" value="submit"> 
</form>
<form method="post">

<table border="2">
<tr>
<th>Date</th>
<th>name</th>
<th>Description</th>
</tr>

<%
try
{
Class.forName("org.postgresql.Driver");
String url="jdbc:postgresql://localhost:5432/StudentTracking";
String username="postgres";
String password="admin";
String query="select * from circular";

Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);

while(rs.next())
{
%>

    <tr><td><%= rs.getDate(1) %></td>
    <td><%= rs.getString(2) %></td>
    <td><%= rs.getString(3)%></td></tr>
        <%

}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }

catch(Exception e)
{
    e.printStackTrace();
    }




%>

</form>

</div>
</body>
</html>