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
<jsp:include page="header.jsp"></jsp:include>
<center>PRODUCT LIST</center>
<form action="" method="post">
<table border="1" cellspacing="0" width="100%">
<tr>
	<th width="10px">
		S.No
	</th>
	<th  width="10px">
		PID
	</th>
	<th width="40px">
		Name
	</th>
	<th width="40px ">
		Supplier
	</th>
	<th width="40px">
		Category
	</th>
	<th width="20">
		Price
	</th>
	<th width="20">
		Stock
	</th>
	<th width="50">
		Description
	</th>
	<th width="40">
		Image
	</th>
	<th width="50">
		Action
	</th>
</tr>
  <c:forEach var="pr" items="${plist}" varStatus="counter">
<tr>
	<td>${counter.count}</td>
	<td>${pr.getPid()}</td>
	<td>${pr.getPname()}</td>
	<td>${pr.getSupplier().getSupplierName()}</td>
	<td>${pr.getCategory().getCatName()}</td>
	<td>${pr.getPrice()}</td>
	<td>${pr.getStock()}</td>
	<td>${pr.getDesc()}</td>
	<td></td>
	<td><input type="submit" value="EDIT" formaction="product?id=${pr.getPid()}"/>
	<input type="submit" value="DELETE" formaction="Delprod/${pr.getPid()}"/></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>