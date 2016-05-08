<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<jsp:include page="./header.jsp"></jsp:include>
<div class="container">

<!-- assign url to variable , Spring url -->
<spring:url value="/project/add" htmlEscape="true" context="helloworld" var="formUrl" />

<!-- spring form  -->
<form:form action="${formUrl}" method="POST" modelAttribute="project" >

  <div class="form-group">
    <label for="name">Name: </label>
    <!-- <input type="text" class="form-control" id="name" name="name" placeholder="Name"> -->
    <form:input path="name" id="name" cssClass="form-control" placeholder="Name" />
  </div>
  <div class="form-group">
    <label for="email">Email: </label>
    <form:input path="email" cssClass="form-control" id="email" placeholder="Password" />
  </div>
  
  <div class="form-group">
    <label for="type">Type: </label>
    <select id="type" name="type">
      <option>Single</option>
      <option>Multi</option>
    </select>
  </div>
  
  <div class="checkbox">
    <label>
      <input name="special" type="checkbox"> Special
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>

</div>
</body>
</html>