<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="./header.jsp"></jsp:include>
<h1>
	Hello world!  
</h1>

<P class="red-text" >  The time on the server is ${serverTime}. </P>

<form action="<spring:url value="/project/add" />" method="post">

<table cellspacing="10px">
<tr>
	<td> <label for="name">Name: </label> </td>
	<td> <input id="name" name="name" /> </td>
</tr>
<tr>
	<td> <label for="email">Email: </label> </td>
	<td> <input id="email" name="email" /> </td>
</tr>
<tr>
	<td> <label for="type">Type: </label> </td>
	<td>
	  <select id="type" name="type">
	      <option value="single" >single</option>
	      <option value="multi"  >multi</option>
	  </select> 
	</td>
</tr>
<tr>
	<td></td>
	<td> <input type="checkbox" id="special" name="special" value="special" /> Special </td>
</tr>
<tr>
   <td></td>
   <td> <input type="submit" value"add" class="btn" /> <input type="reset"  value"reset" class="btn" /> </td>
</tr>
</table>
</form>

<table>
<tr>
	<td> Name: </td>
 	<td> ${project.name} </td>
</tr>
<tr>
	<td> Email: </td>
 	<td> ${project.email} </td>
</tr>
<tr>
	<td> Type: </td>
 	<td> ${project.type} </td>
</tr>
<tr>
	<td> Special: </td>
 	<td> ${project.special} </td>
</tr>

</table>
</body>
</html>
