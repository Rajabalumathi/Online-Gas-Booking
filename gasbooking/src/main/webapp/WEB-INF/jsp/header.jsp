<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import ="org.springframework.security.core.*,org.springframework.security.core.context.*" %>
<h3>Indane Gas</h3>
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script>
function confirmSignOut(aSignOut,signOutUrl) { 
    if (confirm("Are you sure to Sign-out?")) {
        aSignOut.href = signOutUrl;          
        return true;                    
    }
    return false;                         
}
</script>
<div id=usermenu>
<%
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	if (auth != null) {
		out.println("User:" + auth.getName());
	}
%>
<a class=header onclick="return confirmSignOut(this,'/logout')" >Sign out</a> 
</div>
<div class="topnav">
<sec:authorize access="hasRole('ROLE_USER')">
   <a href="/booking">GasBooking</a>
   <a href="/mybooking">MyBooking</a>
   <a href="/myprofile">MyProfile</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
   <div class="menu-dropdown">
    <a class="dropbtn">CustomerDetails 
    </a>
    <div class="dropdown-content">
      <a href="/verifycustomer">NewCustomers</a>
      <a href="/customerdetails">ActiveCustomers</a>
    </div>
    </div>
   <a href="/gasstock">GasStock</a>
   <a href="/gasentry">GasEntry</a>
   <a href="/feedbackview?page=0&size=3">Feedbacks</a>
</sec:authorize>  
</div>