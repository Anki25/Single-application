
<%@ include file="header.jsp" %>

  </div>
  </div>
</nav>


<center>
<h1>Registration</h1>
<p>ALREADY REGISTERED? <a href= "signin">SIGN IN</a></p>
<form:form action="signin"  method="post" commandName="us" >
  
<table>
<tr><td>
Enter Name</td><td><form:input type="text" path="firstname" /></td></tr>
<tr><td>
Enter Password</td><td><form:input type="password" path="password"  /></td></tr>
<tr><td>
Confirmed Password</td><td><input type="password" path="cpassword"></td></tr>
<tr><td>
Date of Birth</td><td><form:input type="text" path="dob" /></td></tr><br>
<tr><td>
Phone no.</td><td><form:input type="text" path="mobileno" /></td></tr>
<tr><td>
Gender</td><td>
Male<form:radiobutton path="gender" /><br>   
Female<form:radiobutton path="gender"/>  
</td></tr>
<tr><td>
City</td><td> <form:input type="text" path="address" />
</td><tr>
<tr><td>
Email Id</td><td><form:input type="text" path="emailid" /></td></tr><br><br>
<tr><td>
<input type="CHECKBOX" NAME="OFFER" CHECKED>I agree to receive information about exciting offers
</td></tr><br>
<tr><td>
<input type="submit" name="submit"></td><td>
<input type="reset" name="reset"></td></tr>
</table>
</form:form>
</center>
<%@ include file="footer.jsp" %>