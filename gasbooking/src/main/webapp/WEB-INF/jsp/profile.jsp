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
<div class="article"><center>
<h3>Profile</h3>
<table>
       <tr>
         <td class="registertable"><b>Name:</b></td>
         <td>${profile.customerName}</td>
      </tr>
      <tr>
         <td class="registertable"><b>Address:</b></td>
         <td>${profile.customerAddress}</td>
      </tr>
      <tr>
         <td class="registertable"><b>Phoneno:</b></td>
         <td>${profile.customerPhoneno}</td>
      </tr>
      <tr>
         <td class="registertable"><b>EmailId:</b></td>
         <td>${profile.customerEmail}</td>
      </tr>
      <tr>
         <td class="registertable"><b>ConnectionType:</b></td>
         <td>${profile.connectionType}</td>
      </tr>
      <tr>
         <td class="registertable"><b>AvailableCylinder:</b></td>
         <td>${profile.customerTotalCylinder}</td>
      </tr>
      </table>
</div>
</body>
</center>
<div class="fixed-footer">
<jsp:include page="footer.jsp"/>
</div>
</html>