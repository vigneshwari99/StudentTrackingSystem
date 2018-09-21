<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student portal</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>#p1 {background-color:rgb(162,74,105);opacity:0.6;
  background-size: cover;
  }
  
  
  
  </style>
</head>
<body>
<h1 align="center">Student/parent login portal</h1>
<form align="center" class="form-inline" id="p1" method="post" action="view">
<div class="container">
 <div class="form-group">
 <label class="col-sm-10" for="email">Roll</label>      
<input type="number"  name= "roll"  required/><br><br>
</div><br><br>   
<div class="form-group">
<label class="col-sm-10" for="dob">DOB</label> 
<input type="password" name="date" required><br><br>  
</div><br><br>  
<div class="form-group">
<input type="submit" class="btn btn-default" value="Sign In">
</div>
      </div>    
</form>




</body>
</html>