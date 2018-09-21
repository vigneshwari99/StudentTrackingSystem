<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Student currentUser = (Student)(session.getAttribute("currentSessionUser"));%>


<table border='1' width='100%'>
<tr><th>roll</th><th>English</th><th>Maths</th><th>Science</th><th>Social</th><th>Language</th><th>Percentage</th><th>semester</th><th>Attendance</th></tr>
<tr><td><%= currentUser.getRoll() %></td><td><%= currentUser.getSub1() %></td><td>"<%= currentUser.getSub2() %>"</td><td><%= currentUser.getSub3() %></td><td><%= currentUser.getSub4() %></td><td><%= currentUser.getSub5() %></td><td><%= currentUser.getPercent() %></td><td><%= currentUser.getSem() %></td><td><%= currentUser.getAtd() %></td>
</body>
</html>