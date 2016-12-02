<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<c:forEach var="users" items="${users}">
		<div style="background-color: grey">
			${users.name} ${users.email} <a href="deleteUsers/${users.id}">delete</a>
		</div>
		<br>
	</c:forEach>

	<h1>Add user with group</h1>



	<br>

	
	<br>
	
	<h1>Add user withOut group</h1>

<sf:form modelAttribute="user" action="saveNewUser" method="post">
<sf:input path="name" placeholder="name"/>
<sf:input path="phone" placeholder="phone"/>
<sf:input path="email" placeholder="email" type="email"/>
<sf:input path="password" type="password" />

<sf:select path="groups">

			<c:forEach var="groups" items="${groups}">
	
			<option value="${groups.id}">${groups.name}</option>

	</c:forEach>
</sf:select>

<button>Save</button>
</sf:form>

</body>
</html>