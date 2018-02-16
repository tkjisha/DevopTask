<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@page import="com.Model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="AddUser" modelAttribute="user">
<table align="center" cellspacing="2">
	<tr>
		<td colspan="2">REGISTRATION</td>
	</tr>
	<tr>
		<td>Email ID</td><td><form:input path="email"/></td>		
	</tr>
	<tr>
		<td>Address</td><td><form:input path="address"/></td>		
	</tr>
	<tr>
		<td>Name</td><td><form:input path="name"/></td>		
	</tr>
	<tr>
		<td>Password</td><td><form:input path="password"/></td>		
	</tr>	
	<tr>
		<td>Phone</td><td><form:input path="phone"/></td>		
	</tr>
	<tr>
		<td col span="2">
			<center><input type="submit" value="Add User"/></center>
		</td>
</table>
</form:form>
</body>
</html>