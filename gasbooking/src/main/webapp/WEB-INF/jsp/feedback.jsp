

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="resources/css/common.css">
   </head>
   <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
   <script type="text/javascript">
      window.onload = function(){ 
               if (confirm("Do you like to provide Feedback?")) {
                      
              return true;                    
          }
         
          window.location.replace("/dashboard");
          return false; 
      }
   </script>
   <div class="fixed-header">
      <jsp:include page="header.jsp"/>
   </div>
   <center>
      <div class="article">
         <h3>Feedbacks</h3>
         <form:form modelAttribute="feedbackdetails" method="post" action="/feedpost" onsubmit="alert('Thanks for your feedback!!!');return true">
            <table>
               <tr>
                  <td class="registertable">
                     <form:hidden path="booking" value="${feedback.booking}"/>
                  </td>
               </tr>
               <tr>
                  <td class="registertable">Enter Your Feedback:</td>
                  <td class="registertable">
                     <form:textarea path="feedback" rows="5"/>
                  </td>
               </tr>
               <tr>
                  <td colspan="2" class="registertable">
                     <input type="submit" value="Submit"/>
                  </td>
               </tr>
            </table>
         </form:form>
      </div>
   </center>
   <div class="fixed-footer">
      <jsp:include page="footer.jsp"/>
   </div>
</html>

