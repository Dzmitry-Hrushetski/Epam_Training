<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<fmt:setLocale value="ru_RU" scope="session" />
<fmt:setBundle basename="text" var="rb" />

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="login.title" bundle="${ rb }" /></title>
</head>
<body>
	<br>
	<br>
	<h3>
		<fmt:message key="login.auth_message" bundle="${ rb }" />
	</h3>
	<br>
	<br>
	<form action="controller" method="post">
		<table>
			<tr>
				<th><fmt:message key="login.login_message" bundle="${ rb }" /></th>
				<th><fmt:message key="login.password_message" bundle="${ rb }" /></th>
				<th></th>
			</tr>
			<tr>
				<td><input type="email" name="login" size="30" maxlength="50" required="required"/></td>
				<td><input type="password" name="password" maxlength="20" size="30"	pattern="[A-Za-z0-9\\._\\-]{5,20}" required="required" /></td>
				<td><input type="submit" value="<fmt:message key="login.enter" bundle="${ rb }" />" /></td>
			</tr>

		</table>
	</form>


</body>
</html>