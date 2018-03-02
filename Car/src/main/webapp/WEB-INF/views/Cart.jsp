<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Model.Product" %>
 <%@ page isELIgnored="false" %> 
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form >
<table border="1" cellspacing="0" width="80%">
<tr>	
	<th>PID</th>
	<th>NAME</th>
	<th>QUANTITY</th>
	<th>ACTION</th>	
</tr>
<tr>	
	<td>${prod.getPid()}</td>
	<td>${prod.getPname()}</td>
	<td><% %></td>
	<td><input type="submit" value="Remove"/></td>
</tr>

</table>
<br><br><br><br>
<input type="submit"  value="Continue Shopping" formaction="addshop " />
<input type="submit"  value="CheckOut" formaction="/checkout"/>
</form>
</body>
</html>