<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="StudentServlet" method="post">
		<input type="text" name="id" placeholder="ID">
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="classroom" placeholder="Classroom">
        <button formaction="StudentServlet/create" >Create</button>
        <button formaction="StudentServlet/update" >Update</button>
       
    </form>


	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Classroom</th>
		</tr>
		<c:if test="${not empty list}">
			<c:forEach var="student" items="${list }">
				<tr>
					<td><c:out value="${student.id}" /></td>
					<td><c:out value="${student.name}" /></td>
					<td><c:out value="${student.classroom}" /></td>
					<td><a href="${pageContext.request.contextPath}/StudentServlet/delete?id=<c:out value="${student.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>