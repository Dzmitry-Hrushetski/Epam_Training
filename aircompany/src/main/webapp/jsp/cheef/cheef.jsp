<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="text" var="rb" />

<!DOCTYPE html>

<html lang="${locale}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="cheef.title" bundle="${ rb }" /></title>
</head>
<body>
	<h3>
		<fmt:message key="aircompany.name" bundle="${ rb }" />
	</h3>

	<br>

	<h4>
		<fmt:message key="cheef.employee_list" bundle="${ rb }" />
	</h4>
	<br>



	<c:set var="position" value="1" scope="request" />
	<form action="ControllerServlet" method="post">
		<label for="position"><fmt:message key="cheef.position_message"	bundle="${ rb }" />:</label>
		 <select autofocus id="position" name="position" onchange="submit()">
			<c:forEach items="${position_list}" var="p"> <option value="${p.id}" ${p.id eq 1 ? 'selected' : ''}>${p.positionName}</option> </c:forEach>
		</select>
	</form>
	
	<br>
	
	

	

<!-- 
	<form action="ControllerServlet" method="post">
		<input type="HIDDEN" name="action" value="cheef_command">
		<table>
			<tr>
				<th><fmt:message key="login.login_message" bundle="${ rb }" /></th>
				<th><fmt:message key="login.password_message" bundle="${ rb }" /></th>
				<th></th>
			</tr>
			<tr>
				<td><input type="email" name="login" size="30" maxlength="50"
					required="required" /></td>
				<td><input type="password" name="password" maxlength="20"
					size="30" pattern="[A-Za-z0-9\\._\\-]{5,20}" required="required" /></td>
				<td><input type="submit"
					value="<fmt:message key="login.enter" bundle="${ rb }" />" /></td>
			</tr>
		</table>
	</form>
	 -->
</body>
</html>