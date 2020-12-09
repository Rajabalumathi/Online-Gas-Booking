<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="resources/css/common.css">
   </head>
   <div class="fixed-header">
      <jsp:include page="header.jsp"/>
   </div>
   <center>
      <div class="article">
         <h3>Customer Feedbacks</h3>
         <table>
            <tr>
               <th class="detailtable">BookingId</th>
               <th class="detailtable">Feedback</th>
               <th class="detailtable">View Booking</th>
               <th class="detailtable">Delete</th>
            </tr>
            <c:choose>
               <c:when test="${feedbackDetails.size()>0}">
                  <c:forEach items="${feedbackDetails}" var="feedback">
                     <tr>
                        <td class="detailtable">${feedback.booking.bookingId}</td>
                        <td class="detailtable">${feedback.feedback}</td>
                        <td class="detailtable"><a class="button" href="/singlebooking/${feedback.booking.bookingId}">View Booking</a></td>
                        <td class="detailtable"><a class="button" href="/singledelete/${feedback.feedbackId}"  onclick="alert('Feedback Deleted!');return true">Delete</a></td>
                     </tr>
                  </c:forEach>
               </c:when>
               <c:otherwise>
                  <tr align="center">
                     <td colspan="4">No feedback provided yet!!!</td>
                  </tr>
               </c:otherwise>
            </c:choose>
         </table>
      </div>
      <c:if test="${feedbackDetails.size()>0}">
         <div>
            <ul>
               <c:forEach begin="0" end="${totalPages-1}" var="page">
                  <li>
                     <a href="/feedbackview?page=${page}&size=${size}">${page+1}</a>
                  </li>
               </c:forEach>
            </ul>
         </div>
   </center>
   </c:if>
   <div class="fixed-footer">
      <jsp:include page="footer.jsp"/>
   </div>
</html>