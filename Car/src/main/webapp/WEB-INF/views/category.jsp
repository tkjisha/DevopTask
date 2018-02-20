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
<jsp:include page="adminadd.jsp"></jsp:include>
<form action="AddCategory"  method="POST">
<table align="center" cellspacing="3" cellpadding="4">
	<tr>
		<td colspan="2">CATEGORY DETAILS</td>
	</tr>
	<tr>
		<td>Category ID</td>		
		<td><input type="text" name="catId"/></td>
	</tr>
	<tr>
		<td>Category Name</td>		
		<td><input type="text" name="catName"/></td>
	</tr>
	
	<tr>
		<td >
			
		</td>
		<td >
			<input type="submit" value="Add"/><input type="reset" value="Cancel"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>