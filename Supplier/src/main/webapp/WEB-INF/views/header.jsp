<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
</head>
<body>
<nav id="navbar-red" class="navbar navbar-inverse navbar-static-top" role="navigation">
<div class="container">
<ul class="nav navbar-nav" >
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="bs-demo-navbar-collapse-1">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
</ul>
</div>
<div class="collapse navbar-collapse" id="bs-demo-navbar-collapse-1">
<ul class="nav navbar-nav" >
<li><a href="#">Home<i class="fa fa-home"></i></a></li>
<li><a href="adminadd">Admin</a></li>

<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
          <li><a href="#">Page 1-4</a></li>
          <li><a href="#">Page 1-5</a></li>
        </ul>
      </li>
      <li><a href="register">Register<i class="fa fa-registered" ></i></a></li>
<li><a href="#">Login<i class="fa fa-sign-in"></i></a></li>
</ul>
</div>
</nav>

</body>
</html>