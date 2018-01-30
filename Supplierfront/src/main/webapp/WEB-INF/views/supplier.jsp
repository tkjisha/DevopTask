<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com.Model.Supplier"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="AddSupplier" modelAttribute="supplier">

<table align="center">
	<tr>
		<td colspan="2">SUPPLIER DETAILS</td>
	</tr>	
	<tr>
		<td>Supplier ID</td><td><form:input path="sid"/></td>		
	</tr>
	<tr>
		<td>Supplier Name</td><td><form:input path="supplierName"/></td>		
	</tr>
	<tr>
		<td >
			<center><input type="submit" value="Add"/></center>
		</td>
		
	</tr>
	
	</table>
	</form:form>
	<table cellspacing="2" align="center">

		<td>
			
			<a href="UpdateSupplier/{supplier.sid}"/>UPDATE</a>
		</td>
	</tr>

</table>
	
</body>
</html>