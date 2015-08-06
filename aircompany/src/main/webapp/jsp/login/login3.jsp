<jsp:root version="2.0" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	
	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
	<jsp:output doctype-root-element="html" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />
	
	<fmt:setLocale value="en_EN" scope="session" />
	<fmt:setBundle basename="text" var="rb" />
	
	<html>
<head>
<title></title>
</head>
<body>
	
	<p>Aircompany airplanes:</p>
	
	<h2><fmt:message key="login.auth_message" bundle="${ rb }" /></h2>
	
	

</body>
	</html>
</jsp:root>