<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Product Add Page</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code="product.products"/></h1>
				<p><spring:message code="product.add.newproduct"/></p>
			</div>		
		</div>
	</section>
	
	<span style="float:right">
		<a href="?language=tr">
			<img src="${contextPath}/resources/images/TR.png"/>
		</a>
		<a href="?language=en">
			<img src="${contextPath}/resources/images/EN.png"/>
		</a>
	</span>
	
	<section class="container">
		<!-- watch out modelAttribute ! -->
		<form:form  modelAttribute="newProduct" class="form-horizontal" method="post">
			<fieldset>
				<legend><spring:message code="product.add.newproduct"/></legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="product.id"/>
					</label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
						<!-- path product sinifindaki degiskenlerimiz burya bind ediyoruz -->
						<form:errors path="productId" cssClass="text-danger"/>
						
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">
						<spring:message code="product.name"/>
					</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice">
						<spring:message code="product.unit.price"/>
					</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
							<form:errors path="unitPrice" class="text-danger"></form:errors>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">
						<spring:message code="product.description"/>
					</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows = "2"/>
						<form:errors path="description" cssClass="text-danger"></form:errors>
						
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="manufacturer">
						<spring:message code="product.manufacturer" />
					</label>
					<div class="col-lg-10">				
						
						<%--								
						<form:select id="manufacturer" path="category" type="text" class="form:input-large">
							<form:option value="Apple">Apple</form:option>
							<form:option value="Google">Google</form:option>
							<form:option value="Samsung">Samsung</form:option>
						</form:select>
						 --%>
						  				 
					    <form:select id="manufacturer" path="manufacturer" type="text" class="form:input-large" items="${manufacturerList}"/>		
					    <!-- ProductManagementController#prepareManufacturerList() den items geliyor. --> 			
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category">
						<spring:message code="product.category" />
					</label>
					<div class="col-lg-10">
						
						<%--
						<form:select id="category" path="category" type="text" class="form:input-large">
							<form:option value="Laptop">Laptop</form:option>
							<form:option value="Tablet">Tablet</form:option>
							<form:option value="Smart Phone">Smart Phone</form:option>
						</form:select>
						 --%> 
						
						 <form:select id="category" path="category" type="text" class="form:input-large" items="${categoryList}"/>
						 
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitsInStock">
						<spring:message code="product.stock"/>
					</label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
						<form:errors path="unitsInStock" cssClass="text-danger" cssStyle="display: inline-flex;"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">
						<spring:message code="product.condition"/>
					</label>
					<div class="col-lg-10">
						
						 <%--
						<form:radiobutton path="condition" value="New" />New 
						<form:radiobutton path="condition" value="Old" />Old 
						<form:radiobutton path="condition" value="Refurbished" />Refurbished
						 --%>
						
						<%--  <form:radiobuttons path="condition" items="${conditionMap}"/>--%>
						
						<c:forEach var="varCondition" items="${conditionMap}">
    						<form:radiobutton path="condition" value="${varCondition.key}" /> 
    						<spring:message code="product.${varCondition.value}"/>
						 </c:forEach>
						
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="<spring:message code='product.add.button'/>"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
