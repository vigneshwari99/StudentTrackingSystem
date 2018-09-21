<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean.Staff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
ul {
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


li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}
.dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
li.dropdown {
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}
.dropdown-content a:hover {background-color: grey}
.dropdown:hover .dropdown-content {
    display: block;
    }
    img{
    padding : 20px;
    margin-left:30px;
    background-color:pink;
    }
</style>
<body>
<% Staff currentUser = (Staff)(session.getAttribute("currentSessionUser"));%>
<h3><marquee>staff <%= currentUser.getName() %> portal</marquee></h3>
<img src="image/bg.jpg" align="center" width="1000" height="150">
 <ul>
 
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Student Details</a>
    <div class="dropdown-content">
      <a href="StudSignup.jsp">Personal Details</a>
      <a href="detail.jsp">Academic Details</a>
      </div>
  </li>
  <li><a href="report">Report</a></li>
  
  <li><a href="search.jsp">Search student</a></li>
  <li><a href="circular.jsp">Circular</a></li>
  <li><a href="viewdata.jsp">view circular</a>
  <li><a href="report1">Logout</a></li>
  
</ul>
  
</body>
</html>