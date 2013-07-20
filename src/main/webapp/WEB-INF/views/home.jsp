<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="include/header.jsp" %>
<script type="text/javascript" src="jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="jquery/json2.js"></script>
<script type="text/javascript" src="org/cometd.js"></script>
<script type="text/javascript" src="jquery/jquery.cometd.js"></script>
<script type="text/javascript" src="resources/js/application.js"></script>
<%--
 The reason to use a JSP is that it is very easy to obtain server-side configuration
 information (such as the contextPath) and pass it to the JavaScript environment on the client.
--%>
<script type="text/javascript">
    var config = {
        contextPath: '${pageContext.request.contextPath}'
    };
</script>
    
<div id="body"></div>
<form name="hud_panel" action="" onSubmit="sendCommand(this);return false;">
	<input type="text" name="hud_input" value="" />
	<input type="submit" value="Submit" />
</form>


<%@ include file="include/footer.jsp" %>
