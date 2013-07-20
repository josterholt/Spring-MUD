<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:import url="../include/header.jsp">
	<c:param name="is_admin" value="true"></c:param>
</c:import>
<h2>Admin Home</h2>
<h3>Content Types</h3>

<h3>Data Utils</h3>
<ul class="unstyled">
	<li><a href="${pageContext.request.contextPath}/admin/populate-data">Populate Data</a></li>
	<li><a href="${pageContext.request.contextPath}/admin/clean-data">Clean Data</a></li>
</ul>
<c:import url="../include/footer.jsp"></c:import>
