<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Model.Category" %>
 <%@ page isELIgnored="false" %> 
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminadd.jsp"></jsp:include>
<form action="AddProduct"  method="POST" enctype="multipart/form-data">
<table align="center" cellspacing="5" cellpadding="5">
	<tr>
		<td colspan="2">PRODUCT DETAILS</td>
	</tr>
	<tr>
		<td>Product Name</td>		
		<td><input type="text" name="pname"/></td>
	</tr>
	<tr>
		<td>Product description</td>		
		<td><input type="text" name="desc" /></td>
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
		<td>Select Category</td>		
		<td>
		<select name="category"/>
		<option value="select">Select</option>
	<c:forEach var="catid" items="${catList}">
		<option value="${catid.getCatId()}">${catid.getCatId()}</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>Select Supplier</td>		
		<td>
		<select name="supplier"/>
		<option value="select">Select</option>
		<c:forEach var="supid" items="${supList}">
		<option value="${supid.getSid()}">${supid.getSid()}</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>Product Image</td>		
		<td><input type = "file" name = "pimage"  size = "50" ></td>
	</tr>
	<tr>
		<td >
			
		</td>
		<td>
		    <input type="submit" value="Add"/>
			<input type="reset" value="Cancel"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>