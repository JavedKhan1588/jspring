<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSpring | Login</title>
</head>
<body>
<p><font color=red>${error}</font>
<form action="/login" method="POST">
	<label>Enter Name:</label>&nbsp; <input type="text" name="username" /> 
	<label>Enter Password:</label>&nbsp; <input type="password" name="password"/>
	<input type="submit" />		
</form>
</body>
</html>