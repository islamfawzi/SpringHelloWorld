<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="./header.jsp"></jsp:include>

<div class="container">

   <h1>Projects</h1>
   <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Type</th>
        <th>Special</th>
      </tr>
    </thead>
    
    
    <tbody>
      <c:forEach items="${projects}" var="project">
		   <tr>
		     <td> ${project.id} </td>
		     <td><a href="<spring:url value="/project/${project.id}" />" > ${project.name} </a></td>
		     <td> ${project.email} </td>
		     <td> ${project.type} </td>
		     <td> ${project.special == true ? "Yes" : "No"} </td>
	       </tr>       
       </c:forEach>
    </tbody>
  </table>
  
  
</div>

</body>
</html>