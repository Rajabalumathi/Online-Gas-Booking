<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
<h2>Gas Entry</h2>
 <form:form id="search" method="POST" modelAttribute="gas" action="/addnewgas/quantity?val=" name="gas" onsubmit="alert('Gas Details are entered!!!');return true">
   <table>
      <tr>
         <td class="registertable">
            <form:hidden path="gasId"/>
         </td>
         
      </tr>
      <tr >
         <td class="registertable">Enter Type :</td>
         <td class="registertable">
         <form:select path="gasType" id="gasType">
             <form:option value="">Please Select</form:option>
             <form:option value="Domestic">Domestic(13 kg)</form:option>
             <form:option value="Industry">Industry(20 kg)</form:option>
             </form:select>
         </td>
      </tr>
       <tr >
         <td class="registertable">Enter Quantity:</td>
         <td class="registertable">
             <select id="dropdown">
             <option value="">Please Select</option>
             <option value="1">1</option>
             <option value="2">2</option>
             <option value="3">3</option>
             <option value="4">4</option>
             <option value="5">5</option>
             </select>
         </td>
      </tr>
      <tr>
         <td class="registertable">Enter Amount :</td>
         <td class="registertable">
            <form:input path="gasAmount" id="gasAmount"/>
         </td>
      </tr>
     
      <tr >
         <td colspan="2" class="registertable">
            <input type="submit" value="Add"/>
         </td>
      </tr>
   </table>
</form:form>
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="/resources/js/custom.js"></script>
</div>
</div>
</center>
</body>
<div class="fixed-footer">
<jsp:include page="footer.jsp"/>
</div>
</html>