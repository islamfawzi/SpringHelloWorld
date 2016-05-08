<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="./header.jsp"></jsp:include>
<div class="container">
<form action="<spring:url value="/project/add" htmlEscape="true" context="helloworld" />" method="post">
  <div class="form-group">
    <label for="name">Name: </label>
    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
  </div>
  <div class="form-group">
    <label for="email">Email: </label>
    <input type="email" class="form-control" id="email" name="email" placeholder="Password">
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
</form>
</div>
</body>
</html>