<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="/resources/css/common.css">
   </head>
   <center>
   <div class="fixed-header">
      <jsp:include page="header.jsp"/>
   </div>
   <div class=article>
      <body>
         <h2>Gas Stock</h2>
         <table>
            <tr>
               <th class="detailtable">Connection Type</th>
               <th class="detailtable">Total Quantity</th>
               <th class="detailtable">Booked</th>
               <th class="detailtable">Unbooked</th>
            </tr>
            <c:forEach items="${gasDetails}" var="entry">
               <tr>
                  <c:forEach items="${entry.value}" var="item" >
                     <td class="detailtable">${item}</td>
                  </c:forEach>
               </tr>
            </c:forEach>
         </table>
      </body>
   </div>
   <div class="fixed-footer">
      <jsp:include page="footer.jsp"/>
   </div>
</html>

