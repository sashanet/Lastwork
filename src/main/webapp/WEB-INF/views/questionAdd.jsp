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


<sf:form modelAttribute="question" action="saveNewQuestion" method="post">
<sf:input path="name" />
<sf:input path="question" />
<sf:input path="points" type="number"/>
<sf:select path="test">

			<c:forEach var="test" items="${test}">
	
			<option value="${test.id}">${test.name}</option>

	</c:forEach>
</sf:select>
<button>Save</button>
</sf:form>

</body>
</html>