<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:import url="../include/header.jsp"></c:import>
<h2>Area List</h2>
<ul class="unstyled">
	<li>${area.name}</li>
</ul>
<c:import url="../include/footer.jsp"></c:import>