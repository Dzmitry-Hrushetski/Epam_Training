<jsp:root version="2.0" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions">
	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
	<jsp:output doctype-root-element="html" doctype-system="" />
	<html>
<head>
<title><c:out value="Parser type - ${param.typeParser}" /></title>
</head>
<body>
	<c:out value="Parser type - ${param.typeParser}" />
	<p>Aircompany airplanes:</p>

	<c:choose>
		<c:when test="${empty airplanes}">
			<p>The aircompany has no airplanes.</p>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<th>Model</th>
					<th>Board number</th>
					<th>Flying range</th>
				</tr>
				<c:forEach var="element" items="${airplanes}" varStatus="status">
					<tr>
						<td><c:out value="${element.modelName}"></c:out></td>
						<td><c:out value="${element.boardNumber}"></c:out></td>
						<td><c:out value="${element.flyingRange}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
	</html>
</jsp:root>