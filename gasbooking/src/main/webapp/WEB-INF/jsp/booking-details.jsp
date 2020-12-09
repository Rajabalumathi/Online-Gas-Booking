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
            <h3>Booking Details</h3>
            <table>
               <tr>
                  <td class="registertable"><b>CustomerId:</b></td>
                  <td>${bookingDetails.get(0)}</td>
               </tr>
               <tr>
                  <td class="registertable"><b>GasId:</b></td>
                  <td>${bookingDetails.get(1)}</td>
               </tr>
               <tr>
                  <td class="registertable"><b>Booked Date:</b></td>
                  <td>${bookingDetails.get(2)}</td>
               </tr>
               <tr>
                  <td class="registertable"><b>Payment Date:</b></td>
                  <td>${bookingDetails.get(3)}</td>
               </tr>
               <tr>
                  <td class="registertable"><b>Delievery Date:</b></td>
                  <td>${bookingDetails.get(4)}</td>
               </tr>
               <tr>
                  <td class="registertable"><b>Delievery Status:</b></td>
                  <td>${bookingDetails.get(5)}</td>
               </tr>
            </table>
         </center>
         </bodey>
   </div>
   <div class="fixed-footer">
   <jsp:include page="footer.jsp"/>      
   </div>
</html>