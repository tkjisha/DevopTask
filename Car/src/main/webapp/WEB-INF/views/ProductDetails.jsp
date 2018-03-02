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
<p>PRODUCT DETAILS</p><BR><BR><BR><BR>
<form action="" method="post">
<img src="${pageContext.request.contextPath}/resources/${prod.getImgname()}" height="250" width="300" align="left"/>
<table align="center">
	<tr>
	
	<td><b>${prod.getPname()}<b></b></td><td></td>
	</tr>
	<tr>
	<td><b>${prod.getSupplier().getSupplierName()}</b></td><td> </td>
	</tr>
	<tr>
	<td><b>${prod.getPrice()}</b></td><td> </td>
	</tr>
	<tr>
	<td><b>Quantity </b></td><td><input type="text" name="pqty" value=""/></td>
	</tr>
	<tr>
	<td><b>${prod.getDesc()}</b></td><td></td>
	</tr>
	<tr><td><input type="submit" value="Add To Cart" formaction="Cart/${prod.getPid()}"/></td></tr>
</table>


</form>
</body>
</html>