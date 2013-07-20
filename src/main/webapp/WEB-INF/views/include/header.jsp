<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<h1>RPG Sample</h1>
<div class="container-fluid">
	<div class="row-fluid">
	Admin: ${is_admin}<br />
		<c:if test="${not empty is_admin}">
		<div class="span2">	
			<c:import url="/WEB-INF/views/include/navAdmin.jsp" />
		</div>
		</c:if>
		<div class="span10">
			<c:if test="${not empty successMessage}">
				<div class="alert alter-success">${successMessage}</div>
			</c:if>

