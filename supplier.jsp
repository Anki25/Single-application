 <%@ include file="header.jsp" %> 
   				<ul class="nav navbar-nav navbar-right">
					<li><a href="signin">Sign In </a></li> 
				 <li><a href="signup">Sign Up</a></li> 
						
				</ul>
			</div>
		</div>
		<br>

		<div>
			<ul class="nav navbar-nav navbar-left">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Categories <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Indoor Lightings</a></li>
						<li><a href="#">flat panel</a></li>
						<li><a href="#">surface panel</a></li>
						<li><a href="#">external lunar</a></li>
						<li><a href="#">led strip</a></li>
						<li><a href="#">color changing led panel light</a></li>
						<li><a href="#">Outdoor Lightings</a></li>
						<li><a href="#">pathway</a></li>
						<li><a href="#">street & roadway</a></li>
						<li><a href="#">decorative street & roadway</a></li>
						<li><a href="#">parking structure</a></li>
						<li><a href="#">high mast</a></li>
					</ul></li>
			</ul>
			<ul>

				<div>

					<form class="bs-example bs-example-form" role="form">
						<div class="row">
							<div class="col-lg-6">
								<div class="input-group">
									<input type="text" class="form-control"> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>

								</div>
							</div>
						</div>
					</form>
				</div>
			</ul>
		</div>
	</nav>	
	
	<h1>Add a Supplier</h1>
	<c:url var="addAction" value="/supplier/add"></c:url>
	<form:form action="${addAction}" commandName="supplier">
	<table class="table table-hover">
	<tr><td>
	<form:label path="sup_name"><spring:message text="Name"/></form:label></td>
	<td><form:input path="sup_name" required="true"/></td></tr>
	<tr><td><form:label path="address"><spring:message text="Address"/></form:label></td>
	<td><form:input path="address" required="true"/></td>
	</tr>
	<tr>
	<td colspan="2"><c:if test="${!empty supplier.sup_name}">
	<input type="submit" value="<spring:message text="Edit Supplier"/>" />
	</c:if><c:if test="${empty supplier.sup_name}">
	<input type="submit" value="<spring:message text="Add Supplier"/>" />
	</c:if></td>
	</tr>
	</table>
	</form:form>
	<br>
	<h3>Supplier List</h3>
	<c:if test="${!empty supplierList}">
	<table class="tg">
	<tr>
	<th width="80">Supplier Id</th>
	<th width="120">Supplier Name</th>
	<th width="120">Address</th>
	<th width="60">Edit</th>
	<th width="60">Delete</th>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr>
	<td>${supplier.sup_Id}</td>
	<td>${supplier.sup_name}</td>
	<td>${supplier.address}</td>
	<td><a href="<c:url value='supplier/edit/${supplier.sup_Id}' />">Edit</a></td>
	<td><a href="<c:url value='supplier/remove/${supplier.sup_Id}' />">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	
<%@ include file="footer.jsp" %>