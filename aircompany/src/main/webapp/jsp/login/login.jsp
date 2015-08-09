<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language1}" />
<fmt:setBundle basename="text" var="rb" />

<!DOCTYPE html>

<html lang="${language}">
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="login.title" bundle="${ rb }" /></title>
    </head>
    <body>
        <form>
        	<label for="language"><fmt:message key="login.lang_message" bundle="${ rb }" />:</label>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="login.lang_en" bundle="${ rb }" /></option>
                <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="login.lang_ru" bundle="${ rb }" /></option>
            </select>
        </form>
    <br>
	<br>
	<h3>
		<fmt:message key="login.auth_message" bundle="${ rb }" />
	</h3>
	<br>
	<form action="ControllerServlet" method="post">
		<input type="HIDDEN" name="action" value="login_command">
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