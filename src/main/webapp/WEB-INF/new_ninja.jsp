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
<title>Add a New Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="head">
			<h1>New Ninja Form</h1>
			<a href='/dojos' class="btn btn-outline-primary">Go back</a>
		</div>
		
		<div class="content">
			<form:form action='/dojos/ninjas/new' method='POST' modelAttribute='ninja'>
				<form:label path="dojo">Dojo:</form:label>
				<form:select class="form-select" path="dojo">
					<c:forEach var="d" items="${dojos}">
						<option value="${d.id}">
							${d.name}
						</option>
					</c:forEach>
				</form:select>
				
				<form:label path="fName">First Name:</form:label>
				<form:errors path="fName" class="text-danger"></form:errors>
				<form:input class="form-control" type='text' path="fName" placeholder="e.g. Jonathan"></form:input>
				
				<form:label path="lName">Last Name:</form:label>
				<form:errors path="lName" class="text-danger"></form:errors>
				<form:input class="form-control" type='text' path="lName" placeholder="e.g. Moore"></form:input>	
				
				<form:label path="age">Age:</form:label>
				<form:errors path="age" class="text-danger"></form:errors>
				<form:input class="form-control" type='number' path="age"></form:input>
				
				<button type='submit' class="btn btn-info">Create</button>		
			</form:form>
		</div>
	</div>
</body>
</html>