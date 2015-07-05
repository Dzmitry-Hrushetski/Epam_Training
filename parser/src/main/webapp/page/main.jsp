<jsp:root version="2.0" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions">
	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
	<jsp:output doctype-root-element="html" doctype-system="" />
	<html>
<head>
<title>Insert title here</title>

</head>
<body>
	Aircompany airplanes:
	
	<table>
		<c:forEach var="element" items="${airplanes}" varStatus="status">
			<tr>
				<td><c:out value="${element}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
</body>
	</html>
</jsp:root>