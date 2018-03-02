<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.Model.Category,com.Model.Product" %>
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
		<td><input type="text" name="pname" value="${prod.getPname()}"/></td>
	</tr>
	<tr>
		<td>Product description</td>		
		<td><input type="text" name="desc" value="${prod.getDesc()}"/></td>
	</tr>
	<tr>
		<td>Product price</td>		
		<td><input type="text" name="price" value="${prod.getPrice()}"/></td>
	</tr>
	<tr>
		<td>Product stock</td>		
		<td><input type="text" name="stock" value="${prod.getStock()}"/></td>
	</tr>
	
	<tr>
		<td>Select Category</td>		
		<td>
		<c:if test="${empty prod}">
		<select name="category"/>
		<option value="select">Select</option>
	<c:forEach var="catid" items="${catList}">
		<option value="${catid.getCatId()}">${catid.getCatId()}</option>
		</c:forEach>
		</select>
		</c:if>
		<c:if test="${not empty prod}">
		<input type="text" name="category" value="${prod.getCategory().getCatId()}"/>
		</c:if>
		</td>
	</tr>
	<tr>
		<td>Select Supplier</td>		
		<td>
		<c:if test="${empty prod}">
		<select name="supplier"/>
		<option value="select">Select</option>
		<c:forEach var="supid" items="${supList}">
		<option value="${supid.getSid()}">${supid.getSid()}</option>
		</c:forEach>
		</select>
		</c:if>
		<c:if test="${not empty prod}">
		<input type="text" name="supplier" value="${prod.getSupplier().getSid()}"/>
		</c:if>
		</td>
	</tr>
	<tr>
		<td>Product Image</td>	
		<c:if test="${empty prod}">	
		<td><input type = "file" name = "pimage"  size = "50" ></td>
		</c:if>
		<c:if test="${not empty prod}">
		<td><input type = "input" name = "pimage"  value="${prod.getImgname()}" size = "50" ></td>
		</c:if>
	</tr>
	<tr>
		<td >
			
		</td>
		<c:if test="${empty prod}">
		<td>
		    <input type="submit" value="Add"/>
			<input type="reset" value="Cancel"/>
		</td>
		</c:if>
		<c:if test="${not empty prod}">
		<td colspan="2">
		<input type="submit" value="Update" formaction="Updateprod/${prod.getPid()}"/>
		</td>
		</c:if>
	</tr>
</table>
</form>
</body>
</html>