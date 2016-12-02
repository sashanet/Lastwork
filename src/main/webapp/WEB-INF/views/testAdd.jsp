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
<c:forEach var="tests" items="${tests}">
	<div style="background-color: grey">
	${tests.name} 
	<a href="deleteTest/${tests.id}">delete</a>
	</div>
	<br>
</c:forEach>

<form action="testSave" method="post">
		<input name ="name" placeholder="testname">
			
			<button>add</button>
			
	
</form>


<form:form modelAttribute="testin" action="saveNewTest" method="post">
<form:input path="name" />

 	<form:select path="questionsList" items="${questionsList}" itemLabel="name"
			itemValue="id">
		</form:select>


<button>Save</button>
</form:form>



<form action="AddGroupsToTest" method="post">


<select name="tests" multiple="multiple">


<c:forEach var="tests" items="${tests}">
	<option value="${tests.id}">
${tests.name}
</option>
</c:forEach></select>




		
		<select name="groups" multiple="multiple">
		
			<c:forEach var="groups" items="${groups}">
				
				<option value="${groups.id}">${groups.name} </option>
				
			</c:forEach>
			
		</select>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		<button>save Tests in groups</button>
	</form>



</body>
</html>