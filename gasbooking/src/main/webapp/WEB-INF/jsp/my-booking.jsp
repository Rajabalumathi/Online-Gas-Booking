<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
</head>
<center>
<div class="fixed-header">
<jsp:include page="header.jsp"/>
</div>
<body>
<div class="article">
<center>
<h3>Booking History</h3>
<table>
<tr>
<th class="detailtable">GasId</th>
<th class="detailtable">BookingDate</th>
<th class="detailtable">PaymentDate</th>
<th class="detailtable">DelieveryDate</th>
<th class="detailtable">DelieveryStatus</th>
</tr>
<c:choose>
<c:when test="${bookingDetails.size()>0}">
<c:forEach items="${bookingDetails}" var="entry">
<tr>
<td class="detailtable">${entry.key}</td>
<c:forEach items="${entry.value}" var="item" >
<td class="detailtable">${item}</td> 
</c:forEach>
</tr>
</c:forEach>
</c:when>
<c:otherwise>
<tr align="center">
<td colspan="4">No Booking yet!!!</td>
</tr>
</c:otherwise>
</c:choose>
</table>
</div>
</center>
</body>
<div class="fixed-footer">
<jsp:include page="footer.jsp"/> 
</div>
</html>