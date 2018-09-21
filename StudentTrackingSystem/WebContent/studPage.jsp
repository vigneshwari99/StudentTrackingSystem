<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {background-color: powderblue;}ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

    </style>
</head>
<body>
<h3>Student/parent Portal</h3>

<% Student currentUser = (Student)(session.getAttribute("currentSessionUser"));%>
<h3>welcome <%= currentUser.getName() %>  parent of <%= currentUser.getPname() %> </h3>



Roll:<%= currentUser.getRoll() %><br><br>
English:<%=currentUser.getSub1() %><br><br>
Maths:<%=currentUser.getSub2() %><br><br>
Science:<%=currentUser.getSub3()%><br><br>
Social Science:<%=currentUser.getSub4()%><br><br>
Language:<%=currentUser.getSub5()%><br><br>
semester:<%=currentUser.getSem() %><br><br>
<ul>
 
  <li><a href="viewdata.jsp">view circular</a>
  
  <li><a href="index.jsp">Logout</a></li>
  
</ul>

</body>
</html>