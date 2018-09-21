<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#borderimg { 
    border: 10px solid transparent;
    padding: 15px;
    border-image: url(border.png) 30 round;
    background-color:rgb(224,64,192);opacity:0.6;
}
</style>
</head>
<body>
<div class="container">
<form align="center" method="post" class="form-inline" action="Register">
<div  id="borderimg">         
<h1 align="center">Staff registration</h1>
<div class="form-group">
<label class="col-sm-10" for="name">Name:</label> 
<input type="text"  name= "name"  /><br><br>
</div><br><br>
<div>
<label class="col-sm-10" for="date">DOB:</label> 
<input type="date"  name= "dob"  /><br><br>
</div><br><br>
<div>
<label class="col-sm-10" for="email">Email:</label>  
<input type="email"  name= "email"  /><br><br>
</div><br><br>
<div>
<label class="col-sm-10" for="univ">University:</label> 
<input type="text"name= "univname"  /><br><br>
</div><br><br>
<div>
<label class="col-sm-10" for="pass">Password:</label>  
<input type="password" name="pass" ></p><br><br>
</div><br><br>

<div>
<input type="submit" class="btn btn-default" value= "submit"  /><br><br>
</div>         
</form>
</div>
</body>
</html>