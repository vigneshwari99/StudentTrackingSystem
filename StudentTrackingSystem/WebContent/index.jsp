 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff portal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>#p1 {background-color:rgb(192,192,192);opacity:0.6;
  background-size: cover;
  }
  
  p{
  color :red;
  }
  
  </style>
</head>
<body>
<h1 align="center">Staff login portal</h1>
<form align="center" id="p1" class="form-inline"   method="post" action="Login">

   <div class="container">
   
   <div class="form-group">
      <label class="col-sm-10" for="email">Email:</label>       

<input type="text" id="inputName" name= "email" placeholder="email"  required/><br><br>
</div><br><br>
<div class="form-group">
      <label  class="col-sm-10" for="pass">Password :</label>
<input type="password" name="pass"  placeholder="password" required><br><br>
</div><br><br>

<p><input type="submit" class="btn btn-default" value="Sign In"></p><br><br>

          
</form>
<p >Not a member? <a href="Register.jsp" >Sign up now</a></p>
<p >If student/parent Login <a href="studReg.jsp">Login students/parents</a></p>
   
   
   </div>

</body>
</html> 