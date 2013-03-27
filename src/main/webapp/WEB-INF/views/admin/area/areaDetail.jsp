<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:import url="../../include/header.jsp"></c:import>
<h2>Area Deatil</h2>
<form:form action="" method="POST" modelAttribute="area">
	<form:label path="name">Name:</form:label> <form:input path="name" /><br />
	<form:label path="x">Grid X:</form:label> <form:input path="x" /><br />
	<form:label path="x">Grid Y:</form:label> <form:input path="y" /><br />
	<input class="btn" type="submit" value="Save" />
</form:form>
<c:import url="../../include/footer.jsp"></c:import>