<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
<h1>RPG Sample</h1>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2">
			<%@ include file="/WEB-INF/views/include/navBasic.jsp" %> 
		</div>
		<div class="span10">
			<c:if test="${not empty successMessage}">
				<div class="alert alter-success">${successMessage}</div>
			</c:if>

