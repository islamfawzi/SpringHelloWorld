<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="./header.jsp"></jsp:include>


<div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Spring example</h1>
        <p>This is a simple spring framework example.</p>
        <p>The time on the server is ${serverTime}..</p>
       
        <div class="row">
            <h2><span class="label label-primary">Id: </span></h2>
        	<h2><span class="label label-default">${project.id}</span></h2>
        </div> 
        <div class="row">
            <h2><span class="label label-primary">Name: </span></h2>
        	<h2><span class="label label-default">${project.name}</span></h2>
        </div> 
        <div class="row">
        	<h2><span class="label label-primary">Email: </span></h2>
        	<h2><span class="label label-default">${project.email}</span></h2>
        </div> 
        <div class="row">
        	<h2><span class="label label-primary">Type: </span></h2>
        	<h2><span class="label label-default">${project.type}</span></h2>
        </div> 
        <div class="row">
        	<h2><span class="label label-primary">Special: </span></h2>
        	<h2><span class="label label-default">${project.special}</span></h2>
        </div> 
      </div>

 </div> <!-- /container -->
    

	


	 

</body>
</html>
