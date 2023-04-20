<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix= "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="head">
			<h1>Welcome to Coding Dojo</h1>
			<table class="table">
				<thead>
					<tr>
						<th>All Locations</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="d" items="${dojos}">
						<tr>
							<td><a href="/dojos/${d.id}"><c:out value="${d.name}"></c:out></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>			
		</div>
		
		<div class="content">
			<!--NEW DOJO FORM-->
			<div class="new_dojo">
				<h3>New Dojo</h3>
				<form:form action='/dojos/new' method='POST' modelAttribute='dojo'>
					<form:label path="name">Location:</form:label>
					<form:errors path="name" class="text-danger"></form:errors>
					<form:input class="form-control" type='text' path="name" placeholder="e.g. Los Angeles"></form:input>
					<button type='submit' class="btn btn-success">Create</button>
				</form:form>
			</div>
			<!--CLICK TO ACCESS NEW NINJA FORM-->
			<div class="new_ninja">
				<a href='/dojos/ninjas' class="btn btn-light">Add a New Ninja</a>
			</div>
		</div>
	</div>
</body>
</html>