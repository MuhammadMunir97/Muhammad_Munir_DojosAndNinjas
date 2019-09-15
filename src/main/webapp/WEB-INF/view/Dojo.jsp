<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALL Dojos</title>
</head>
<body>

<h1>ALL Dojos</h1>
<a href="/dojo/new">New Dojo</a>
<a href="/dojo/ninja/new">New Ninja</a>
<table>
    <thead>
        <tr>
            <th><h3>Name</h3></th>
            <th><h3>Number Of Students</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${dojos}" var="dojo">
        <tr>
        	<td><a href="/dojo/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
        	<td><c:out value="${dojo.size}"/></td>
            <td>
            <form action="/dojo/${dojo.id}" method="post">
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