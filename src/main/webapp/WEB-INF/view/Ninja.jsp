<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Ninjas</title>
</head>
<body>
<h1>ALL Ninjas</h1>
<a href="/dojo/new">New Dojo</a>
<a href="/dojo/ninja/new">New Ninja</a>
<table>
    <thead>
        <tr>
            <th><h3>Dojo</h3></th>
            <th><h3>Full Name</h3></th>
            <th><h3>Age</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${ninjas}" var="ninja">
        <tr>
        	<td><c:out value="${ninja.dojo.name}"/></td>
        	<td><c:out value="${ninja.firstName}  ${ninja.lastName}"/></td>
        	<td><c:out value="${ninja.age}"/></td>
            <td>
            <form action="/ninja/${ninja.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>