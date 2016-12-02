<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="groups" items="${groupsaa}">
	<div style="background-color: grey">
	
	
	${groups.name}
	<a href="deleteGroups/${groups.id}">delete</a>
	</div>
	<br>
</c:forEach>

GroupsAdd

<br>

<form:form action="addNewGroup" modelAttribute="group" method="post">
		<form:input path ="name" placeholder="groupname" />
			
			<button>SignUp</button>
			
	
</form:form>


<form action="saveUsersInGroups" method="post">


<select name="groupsId">
<c:forEach var="groups1" items="${groups1}">
	<option value="${groups1.id}">
${groups1.name}
</option>
</c:forEach></select>




		
		<select name="usersId" multiple="multiple">
		
			<c:forEach var="users" items="${users}">
				
				<option value="${users.id}">${users.name} </option>
				
			</c:forEach>
			
		</select>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		<button>save users in groups</button>
	</form>

	
	
</body>
</html>