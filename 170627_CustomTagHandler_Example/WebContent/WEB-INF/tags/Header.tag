<%@ tag language="java" pageEncoding="UTF-8" body-content="tagdependent" %>
<%@ attribute name="fontColor" required="true" %>
<%@ attribute name="subTitle" required="true" %>
<em><strong>
	<font color="${fontColor}">
		<jsp:doBody/><br/>
		${subTitle}
	</font>
</strong></em>