<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Model.Category" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminadd.jsp"></jsp:include>
<form action="AddProduct"  method="POST">
<table align="center" cellspacing="3" cellpadding="4">
	<tr>
		<td colspan="2">CATEGORY DETAILS</td>
	</tr>
	<tr>
		<td>Product Name</td>		
		<td><input type="text" name="pname"/></td>
	</tr>
	<tr>
		<td>Product description</td>		
		<td><input type="text" name="pdesc"/></td>
	</tr>
	<tr>
		<td>Product price</td>		
		<td><input type="text" name="price"/></td>
	</tr>
	<tr>
		<td>Product stock</td>		
		<td><input type="text" name="stock"/></td>
	</tr>
	<tr>
		<td >
			<center><input type="submit" value="Add"/></center>
		</td>
		<td >
			<center><input type="reset" value="Cancel"/></center>
		</td>
	</tr>
	
	<tr>
		<td>Select Category</td>		
		<td>
		<select name="category"/>
		<option value="select">Select</option>
	
		<option value="${catList }">${catList}</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>Select Supplier</td>		
		<td>
		<select name="Supplier"/>
		<option value="select">Select</option>
		</select>
		</td>
	</tr>
</table>
</form>
</body>
</html>