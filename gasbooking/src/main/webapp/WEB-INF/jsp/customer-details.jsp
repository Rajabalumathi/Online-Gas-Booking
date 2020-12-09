

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="resources/css/common.css">
   </head>
   <div class="fixed-header">
      <jsp:include page="header.jsp"/>
   </div>
   <div class=article>
      <body>
         <center>
            <h2>Active Customers Detail</h2>
            <table  >
               <tr >
                  <th class="detailtable">CustomerId</th>
                  <th class="detailtable">Name</th>
                  <th class="detailtable">Address</th>
                  <th class="detailtable">Email</th>
                  <th class="detailtable">Phoneno</th>
                  <th class="detailtable">Connection-Type</th>
                  <th class="detailtable">Proof-document</th>
               </tr>
               <c:forEach items="${customerDetails}" var="customer">
                  <tr>
                     <td class="detailtable">${customer.customerId}</td>
                     <td class="detailtable">${customer.customerName}</td>
                     <td class="detailtable">${customer.customerAddress}</td>
                     <td class="detailtable">${customer.customerEmail}</td>
                     <td class="detailtable">${customer.customerPhoneno}</td>
                     <td class="detailtable">${customer.connectionType}</td>
                     <td class="detailtable">
                        <c:url value="/downloadFile/${customer.customerId}" var="downloads"/>
                        <a class="button" href="${downloads}"> Download </a>
                     </td>
                  </tr>
               </c:forEach>
            </table>
         </center>
      </body>
   </div>
   <div class="fixed-footer">
      <jsp:include page="footer.jsp"/>
   </div>
</html>

