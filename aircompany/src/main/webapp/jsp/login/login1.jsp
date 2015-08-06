<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />

	<fmt:setLocale value="" scope="session" />
	<fmt:setBundle basename="text" var="rb" />

	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><fmt:message key="login.title" bundle="${ rb }" /></title>
</head>
<body>
	<div>
		<span><fmt:message key="login.auth_message" bundle="${ rb }" /></span>
	</div>
	<br></br>
	<form action="controller" method="post">
	
		<input type="HIDDEN" name="action" value="auth"/>
		<input type="HIDDEN" name="lang" value="${locale}"/>
		
		<fmt:message key="login.enter_pass_message" bundle="${ rb }" />
		<br></br>
		<input type="email" name="login" size="30" maxlength="50" required="required">
		<br> </br>
		<fmt:message key="login.password_message" bundle="${ rb }" /> 
		<br></br>
		<input type="password" name="password" maxlength="20" size="30"
			pattern="[A-Za-z0-9\\._\\-]{5,20}" required="required"/>
		
		
	</form>
</body>
	</html>
</jsp:root>