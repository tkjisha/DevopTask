<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page import="com.Model.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="AddCategory" modelAttribute="category" method="POST">
<table align="center" cellspacing="2">
	<tr>
		<td colspan="2">CATEGORY DETAILS</td>
	</tr>
	<tr>
		<td>Category ID</td>		
		<td><form:input path="catId"/></td>
	</tr>
	<tr>
		<td>Category Name</td>		
		<td><form:input path="catName"/></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<center><input type="submit" value="Add"/></center>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>