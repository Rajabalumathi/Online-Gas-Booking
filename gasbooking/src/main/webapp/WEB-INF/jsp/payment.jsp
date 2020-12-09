<%@ page import ="org.springframework.security.core.*,org.springframework.security.core.context.*" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
</head>
<center>
<div class="fixed-header">
<jsp:include page="header.jsp"/>
</div>
<body>
<div class="article"><center>
<h3>Payment</h3>
<form method="post" action="/payment?gasId=${gasdisplay.gasId}" onsubmit="alert('Paid Succesfully');return true">
<table >
<tr>
<td class="registertable">Account holder:</td>
<td class="registertable">
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	if (auth != null) {
		out.println(""+ auth.getName());
	}
%>
</td></tr>
<tr><td class="registertable">Gas Type:</td>
<td class="registertable">${gasdisplay.gasType}</td></tr>
<tr><td class="registertable">Gas Amount:</td>
<td class="registertable">${gasdisplay.gasAmount}</td></tr>
<tr>
<td colspan="2" class="registertable">
<input type="submit" value="Pay Now"/></td></tr>
</table>
</form>
<div class="fixed-footer">
<jsp:include page="footer.jsp"/>
</div>
</html>