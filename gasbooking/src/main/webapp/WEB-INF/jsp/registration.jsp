<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="org.springframework.security.core.*,org.springframework.security.core.context.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Customer Entry</title>

<link rel="stylesheet" href="<c:url value="/resources/css/common.css"/>">
<div class="fixed-header">
<div class="topnav">
  <h2>Indane Gas</h2>
  </div>
<div id=usermenu>
<a class=header href="/signin" >Sign in</a> 
</div>
</div> 
<div class="fixed-footer">
   <center>Copyright &copy; 2020 Indane Gas</center>        
    </div>
</head>
<body>
<div class="article"><center>
<div id="msg"><h3>${msg}</h3></div>
<h2>Customer <c:out value="${customer.customerId != 0 ? 'Update' : 'Registration' }" /></h2>
 <form:form method="POST" modelAttribute="customer" enctype = "multipart/form-data" action="/addnew" name="customerForm">
   <table>
      <tr>
         <td class="registertable">
            <form:hidden path="customerId"/>
         </td>
      </tr>
      <tr >
         <td class="registertable">Enter Name :</td>
         <td class="registertable">
            <form:input path="customerName" id="customerName" />
         </td>
      </tr>
      <tr >
         <td class="registertable">Enter Address :</td>
         <td class="registertable">
            <form:input path="customerAddress" id="customerAddress"/>
         </td>
      </tr>
      <tr >
         <td class="registertable">Enter Phoneno :</td>
         <td class="registertable">
            <form:input path="customerPhoneno" id="customerPhoneno"/>
         </td>
      </tr>
      <tr >
         <td class="registertable">Enter Email :</td>
         <td class="registertable">
            <form:input path="customerEmail" id="customerEmail"/>
         </td>
      </tr>
      <tr >
         <td class="registertable" >Enter Password :</td>
         <td class="registertable">
            <form:input type="password" path="customerPassword" id="customerPassword"/>
         </td>
      </tr>
      <tr>
       <td class="registertable" >Connection Type:</td>
       <td class="registertable">
         <form:select path="connectionType" id="connectionType">
             <form:option value="">Please Select</form:option>
             <form:option value="Domestic">Domestic(13 kg)</form:option>
             <form:option value="Industry">Industry(20 kg)</form:option>
             </form:select>
         </td>
      </tr>
      <tr>
         <td class="registertable">Upload Address Proof:</td>
         <td class="registertable"><input type="file" name="file"/>
       </td>
      </tr>
      <tr>
      <td><input type="checkbox" onclick="myFunction()" >Show Password</td>
         <td colspan="2" class="registertable">
            <input id="addNew" type="submit" value="<c:out value="${customer.customerId != 0 ? 'Update' : 'Register'}"></c:out>"/>
         </td>
      </tr>
   </table>
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="/resources/js/custom.js"></script>
</form:form>
</div>
</div>

</center>
</body>

</html>
