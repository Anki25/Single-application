<%@ include file="adminheader.jsp"%>


<div class="col-md-9">
   <form:form action="register"  method="post" commandName="prod" >

<table class="table table-hover">
<tr>
    <th>Add the products</th>
    </tr>
    <tr>
    <td>Enter Product Name:</td>
  <td><form:input type="text" path="pro_name" /></td>
  </tr>
  <tr>
  <td>Description:</td>
  <td><form:textarea path="description" rows="5" cols="30" /></td>
  </tr>
  <tr>
  <td>Price:</td>
  <td>Rs.<form:input type="text" path="price" /></td>
  </tr>
  <tr>
  <td>Quantity:</td>
  <td><form:input type="text" path="quantity" /></td>
  </tr>  
      <tr>
      <td>Image</td>
      <td><form:input type="File" path="image" /></td>      
      </tr>
      <tr>
      <td><form:input type="submit" path="image" />
      </tr>
      
</table>
</form:form>
</div>
</div>
</div>

<%@ include file="footer.jsp"%>