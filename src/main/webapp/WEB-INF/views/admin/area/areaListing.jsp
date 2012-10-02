<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="../../include/header.jsp" %>
<ul class="unstyled">
<c:forEach items="quests" var="quest">
	<li><a href="/quests/${quest.id}">${quest.name}</a></li>
</c:forEach>
</ul>
<%@ include file="../../include/footer.jsp" %>
