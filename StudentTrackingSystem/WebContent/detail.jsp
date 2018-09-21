<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<style>
#borderimg {
	border: 1px solid black;
	padding: 15px;
	margin:100px;
	margin-top: 10px;
	margin-bottom:100px;
	margin-left:75px;
	margin-right:75px;
	background-color:skyblue;
	
}
#f1{
padding :15px;
border : 1px solid black;
background-color:tomato;
}
input[type=number], select {
    width: 30%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
</style>

<script type="text/javascript">
	function add_number() {
		var first_number = parseInt(document.getElementById("eng").value);
		var second_number = parseInt(document.getElementById("mat").value);
		var second = parseInt(document.getElementById("sci").value);
		var sec = parseInt(document.getElementById("ssc").value);
		var se = parseInt(document.getElementById("lan").value);
		var result = first_number + second_number + second + sec + se;
		document.getElementById("per").value = result/5;
	}
</script>


<body>
	<h3 id="f1" align="center">Student Academic details</h3>
	<form align="center" class="form-inline" method="post" action="Detail">
		

		<div id="borderimg" class="container">
		<select name ="sem">
			<option  value="sem1">sem1</option>
			<option  value="sem2">sem2</option>
			<option  value="sem3">sem3</option>

		</select>
		<br><br>
			<div class="form-group">
				<label class="col-sm-10" for="email">Roll No:</label> <br>
				<input type="number" name="roll" placeholder="rollno" required /><br>
				<br>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label class="col-sm-10">English:</label><br> 
				<input type="number" id="eng" name="eng" required /><br>
				<br>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label class="col-sm-10">Maths:</label> <br>
				<input type="number" id="mat" name="mat" required /><br>
				<br>
			</div>
			<br>
			<br>

			<div class="form-group">
				<label class="col-sm-10">science:</label><br>
				 <input type="number"name="sci" id="sci" required /><br>
				<br>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label class="col-sm-10">SocialScience:</label><br>
				 <input	type="number" name="ssc" id="ssc" required /><br>
				<br>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label class="col-sm-10">Language:</label><br>
				 <input type="number"name="lan" id="lan" required /><br>
				<br>
			</div>
			<br>
			
			<div class="form-group">
				<label class="col-sm-10">percentage</label><br> 
				<br> <input type="button" name="clickbtn" value="Display percentage"
				onclick="add_number()"><br>
				<input type="number" name="per" id="per" required /><br>
				<br>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label class="col-sm-10" min="1" max="100">Attendance:</label><br>
				 <input	type="number" name="att" required /><br>
				<br>
			</div>
			<br>
			<br>
			<p>
				<input type="submit" class="btn btn-default" value="save">
			</p>
			<br>
			<br>

		</div>


	</form>


</body>
</html>