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
<p><center>PRODUCT LIST</center></p>
<form action="" method="post">
<table border="1" cellspacing="0" width="100%">
<tr>
	<th>SNo</th>
	<th>PID</th>
	<th>NAME</th>
	<th>SUPPLIER</th>
	<th>CATEGORY</th>
	<th>PRICE</th>
	<th>STOCK</th>
	<th>DESCRIPTION</th>
	<th>IMAGE</th>	
	<th>ACTION</th>
	
</tr>

<c:forEach var="pr" items="${prodlist}" varStatus="counter">
<tr>
	<td>${counter.count}</td>
	<td>${pr.getPid()}</td>
	<td>${pr.getPname()}</td>
	<td>${pr.getSupplier().getSupplierName()}</td>
	<td>${pr.getCategory().getCatName()}</td>
	<td>${pr.getPrice()}</td>
	<td>${pr.getStock()}</td>
	<td>${pr.getDesc()}<input type="hidden" name="cid" value="${pr.getCategory().getCatId()}"/></td>
	<td><img src="${pageContext.request.contextPath}/resources/${prod.getImgname()}" height="150" width="200"/> </td>
	
	<td><input type="submit" value="Details" formaction="ProductDetails?pid=${pr.getPid()}"/></td>
	</tr>
	</c:forEach>

</table>
</form>
</body>
</html>