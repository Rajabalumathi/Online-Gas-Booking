<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<!-- Custom CSS -->
 <link rel="stylesheet" href="<c:url value="/resources/css/common.css"/>">
</head>
<center>
<h1>Sign-in</h1>
<div>${msg}</div>
<div class=myclass>
<form method="POST" action="/signin">
<br>
	 <input type="text" name="username" placeholder="Username"/><br><br>
	<input type="password" name="password" placeholder="Password"/><br><br>
	<input type="submit" name="submit" value="Submit" /><br><br>
	<a href="/registration">New Customer Register</a> 
</form>
</div>
</center>
</html>