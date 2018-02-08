<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@page  isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- header -->
<%@include file="./shared/header.jsp" %>
<!--<c:set var="title" value="${pageval}"/>
 hi ${title}
 <c:if test = "${title == 'category'}"> 
 <%@include file="category.jsp" %>
</c:if>
<c:if test = "${title == 'supplier'}"> 
 <%@include file="supplier.jsp" %>
</c:if>
<!-- footer -->
<%@include file="./shared/footer.jsp" %>
</body>
</html>