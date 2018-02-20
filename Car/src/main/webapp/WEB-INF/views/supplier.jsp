<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page import="com.Model.Supplier" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminadd.jsp"></jsp:include>
<form action="AddSupplier" method="post">
<table align="center" cellspacing="3" cellpadding="4">
	<tr>
		<td colspan="2">SUPPLIER DETAILS</td>
	</tr>	
	<tr>
		<td>Supplier ID</td><td><input type="text" name="sid"/></td>		
	</tr>
	<tr>
		<td>Supplier Name</td><td><input type="text" name="supName"/></td>		
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