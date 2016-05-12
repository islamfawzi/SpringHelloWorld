<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<jsp:include page="./header.jsp"></jsp:include>
<div class="container">

<!-- assign url to variable , Spring url -->
<!-- <spring:url value="/project/review" htmlEscape="true" context="helloworld" var="formUrl" /> -->
<spring:url value="/project/add" htmlEscape="true" context="helloworld" var="formUrl" />

<!-- spring form  -->
<form:form action="${formUrl}" method="POST" modelAttribute="project" >

  <div class="form-group">
    <label for="name">Name: </label>
    
    <!-- <input type="text" class="form-control" id="name" name="name" placeholder="Name"> -->
    <form:input path="name" id="name" cssClass="form-control" placeholder="Name" />
    
    <!-- Validation error message -->
    <p style="color: red; font-style: italic;">
    <form:errors path="name" /> 
    </p>
    
  </div>
  
  <div class="form-group">
    <label for="email">Email: </label>
    
    <form:input path="email" cssClass="form-control" id="email" placeholder="Password" />
    
    <!-- Validation error message -->
    <p style="color: red; font-style: italic;">
    <form:errors path="email" /> 
    </p>
    
  </div>
  
  <hr />
  
  <div class="form-group">
    <label for="sponser-name">Sponser name: </label>
    <form:input path="sponser.name" cssClass="form-control" id="sponser-name" placeholder="sponser name" />
  </div>
  
  <div class="form-group">
    <label for="sponser-email">Sponser email: </label>
    <form:input path="sponser.email" cssClass="form-control" id="sponser-email" placeholder="sponser email" />
  </div>
  
  <div class="form-group">
    <label for="sponser-phone">Sponser phone: </label>
    <form:input path="sponser.phone" cssClass="form-control" id="sponser-phone" placeholder="sponser phone" />
  </div>
  
  <hr />
  
  <div class="form-group">
    <label for="contact1">Contact1: </label>
    <form:input path="contacts[0]" cssClass="form-control" id="contact1" placeholder="contact1" />
  </div>

  <div class="form-group">
    <label for="contact2">Contact2: </label>
    <form:input path="contacts[1]" cssClass="form-control" id="contact2" placeholder="contact2" />
  </div>
  
  <div class="form-group">
    <label for="contact3">Contact3: </label>
    <form:input path="contacts[2]" cssClass="form-control" id="contact3" placeholder="contact3" />
  </div>
  
  <hr />
    
  <div class="form-group">
    <label for="type">Type: </label>
    <form:select path="type" id="type" items="${selectValues}" />
  </div>
  
  <div class="checkbox">
    <label>
    
      <form:checkbox path="special" />   <label for="special">Special</label>
    </label>
  </div>
  
  <div class="checkbox">
    <label>
    	<form:checkboxes path="indicators" items="${checkboxes}" cssClass="checkboxes" />
    </label>
  </div>
  
  <div class="checkbox">
    <form:radiobuttons path="unitOfMeasure" items="${radiobtns}" cssClass="radiobtns" />
  </div>
  
  <div class="form-group">
    <label for="notes" >Notes</label>
    <form:textarea id="notes" path="notes" cssClass="form-control" rows="3" />
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>

</div>
</body>
</html>