<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<spring:url value="/resources/css/main.css" />" type="text/css" />
</head>
<body>
<h1>
	Hello world!  
</h1>

<P class="red-text" >  The time on the server is ${serverTime}  ${webappRoot}. </P>
</body>
</html>
