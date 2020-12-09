<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">


</head>
<div class="fixed-header">
   <jsp:include page="header.jsp"/>
</div>
<div class=article>
   <body>
      <center>
         <h4>Available number of cyclinder:${customer.customerTotalCylinder}</h4>
         <c:choose>
            <c:when test="${customer.customerTotalCylinder== 0}">
               <h4>Total Cylinder quantity is 0,so no more booking can be done!!!!</h4>
            </c:when>
            <c:when test="${count== 0}">
               <h4>Cylinder is out of Stock!!!Please try again later..</h4>
            </c:when>
            <c:otherwise>
               <h4>To proceed booking</h4>
               Click: <a class="button" id="book" href="/generateOtp">book</a>
               <h4>OTP has been send Your Registered Mail</h4>
               <form id="search" method="post" action="/validateOtp/optnum?val=">
                  <table>
                     <tr>
                        <td class="registertable">
                           Enter OTP:
                        </td>
                        <td class="registertable">
                           <input type="text" id="dropdown"/>
                        </td>
                     </tr>
                     <tr>
                        <td colspan="2" class="registertable">
                           <input id="otpsubmit" type="submit" name="submit" value="Submit"/>
                        </td>
                     </tr>
                  </table>
               </form>
               <br>
               <div id="msg">
                  <h4>${msg}</h4>
               </div>
            </c:otherwise>
         </c:choose>
      </center>
   </body>
</div>
<div class="fixed-footer">
   <jsp:include page="footer.jsp"/>
</div>
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="/resources/js/custom.js"></script>
</html>

