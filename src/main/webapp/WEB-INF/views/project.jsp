<jsp:include page="./header.jsp"></jsp:include>

<div class="container">      
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
      	<h2><span class="label label-default">${ project.special == true? "Yes" : "No" }</span></h2>
      </div> 
    </div>
 </div> 
    
</body>
</html>