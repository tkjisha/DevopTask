<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
<form action="login" method="post">
<table align="center" cellspacing="3" cellpadding="5">
	<tr>
		<td colspan="2">LOGIN</td>
	</tr>
	<tr>
		<td>Email ID</td><td><input type="text" name="email"/></td>		
	</tr>
	<tr>
		<td>Password</td><td><input type="password" name="password"/></td>			
	</tr>
	<tr>
		<td >
			<center><input type="submit" value="Login"/></center>
		</td>
		<td >
			<center><input type="reset" value="Cancel"/></center>
		</td>
	</table>
	</form>
</body>
</html>