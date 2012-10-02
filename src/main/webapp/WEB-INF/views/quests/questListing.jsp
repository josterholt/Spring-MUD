<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="../include/header.jsp" %>
<c:forEach items="quests" var="quest">
${quest.name}<br />
</c:forEach>
<%@ include file="../include/footer.jsp" %>