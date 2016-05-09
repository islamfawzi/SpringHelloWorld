<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./header.jsp"></jsp:include>
<div class="container">

  <div>
    <label>Name: </label>
    <span> ${project.name} </span>
  </div>
  
  <div>
    <label>Email: </label>
        <span> ${project.email} </span>
  </div>
  
  <hr />
  
  <div>
    <label>Sponser name: </label>
    <span> ${project.sponser.name} </span>
  </div>
  
  <div>
    <label>Sponser email: </label>
    <span> ${project.sponser.email} </span>
  </div>
  
  <div>
    <label>Sponser phone: </label>
    <span> ${project.sponser.phone} </span>
  </div>
  
  <hr />
  
  <div>
    <label> Contacts: </label> |
    	<c:forEach items="${project.contacts}" var="contact">
    	    ${contact} |
    	</c:forEach>
  </div>
  
  <hr />
  
    
  <div>
    <label>Type: </label>
    <span> ${project.type} </span>
  </div>
  
  <div>
    <label> Special: </label> <span> ${project.special} </span>
  </div>
  
  <div>
    <label> indicators: </label> |
    	<c:forEach items="${project.indicators}" var="ind">
    	    ${ind} |
    	</c:forEach>
  </div>
  
  <div>
    <label> units Of Measure : </label> <span> ${project.unitOfMeasure} </span>
  </div>
  
  <div>
    <label>Notes</label>
    <span> ${project.notes} </span>
  </div>
  
  <a href="<spring:url value="/project/add"  />" class="btn btn-primary" >Edit</a>
  <a href="<spring:url value="/project/save" />" class="btn btn-success">Save</a>
  
</div>
</body>
</html>