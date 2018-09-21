<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#p1 {
	padding: 0px;
	border: 1px solid black;
	width: 55%;
	float: left;
	padding: 15px;
	margin-top: 0px;
	margin-bottom: 100px;
	margin-right: 50px;
	margin-left: 280px;
	background-color: pink;
}

#f1 {
	border: 1px solid red;
	padding: 15px;
	background-color: grey;
}



input[type=text], select {
	width: 30%;
	padding: 12px 20px;
	margin: 5px 5px;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=number], select {
	width: 30%;
	padding: 12px 20px;
	margin: 5px 5px;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=date], select {
	width: 30%;
	padding: 12px 20px;
	margin: 5px 5px;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=email], select {
	width: 30%;
	padding: 12px 20px;
	margin: 5px 5px;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 10px;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}
input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: right;
}
</style>
<body>
	<h1 id="f1" align="center">Student Personal Details</h1>
	<div class="con">
		<form align="center" id="p1"  method="post"class="form-inline" action="StudReg">

			<div class="col-25">
			<label>Roll no :</label>
	        </div>
	        <div class="col-75"><input type="number"  name="roll" /></div>
	
	
	<div class="col-25">
		<label>Name :</label>
	</div>
	<div class="col-75"><input type="text" name="name"  /></div>
	
	<br>
	<br>

	<div class="col-25">
		<label>DOB :</label>
	</div>
	<div class="col-75" ><input type="date" name="dob" /></div>
	
	<br>
	<br>

	<div class="col-25">
		<label>Email:</label>
	</div>
<div class="col-75" ><input type="email"  name="email" /></div>
	
	<br>
	<br>

	<div class="col-25">
		<label>PName:</label>
	</div>
<div class="col-75" ><input type="text" name="pname"  /></div>
	
	<br>
	<br>

	<div class="col-25">
		<label>Mobile:</label>
	</div>
<div class="col-75" ><input type="number" name="mob" /></div>
	
	</p>
	<br>
	<p align="center" >
	<input type="submit" class="btn btn-default" value="submit" />
	</p>


	</form>
	</div>
</body>
</html>