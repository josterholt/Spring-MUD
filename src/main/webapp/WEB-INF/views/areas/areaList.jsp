<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:import url="../include/header.jsp"></c:import>
<h2>Area List</h2>
<ul class="unstyled">
<c:forEach items="${areas}" var="area">
	<li><a href="${pageContext.request.contextPath}/areas/${area.id}">${area.name}</a></li>
</c:forEach>
</ul>
<c:import url="../include/footer.jsp"></c:import>