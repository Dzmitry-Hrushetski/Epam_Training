<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="request" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" var="rb" />

<!DOCTYPE html>

<html lang="${language}">
    <head>
       	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="login.title" bundle="${ rb }" /></title>
    </head>
    <body>
    <h3>
    <c:out value="${language}"></c:out>
    <c:out value="${language eq 'ru_RU' ? language='ru' : language='en'}"></c:out>
    <c:out value="${language}"></c:out>
		<fmt:message key="aircompany.name" bundle="${ rb }" />
	</h3>
        <form action="ControllerServlet" method="post">
        <input type="hidden" name="action" value="language_command">
        <input type="hidden" name="locale" value="${language}">
        	<label for="language"><fmt:message key="login.lang_message" bundle="${ rb }" />:</label>
            <select autofocus id="language" name="language" onchange="submit()">
                <option value="en" ${language eq 'en' ? 'selected' : ''}><fmt:message key="login.lang_en" bundle="${ rb }" /></option>
                <option value="ru" ${language eq 'ru' ? 'selected' : ''}><fmt:message key="login.lang_ru" bundle="${ rb }" /></option>
            </select>
        </form>
    <br>
	<h4>
		<fmt:message key="login.auth_message" bundle="${ rb }" />
	</h4>
	<br>
	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="login_command">
		<!-- <input type="hidden" name="locale" value="${language}">  -->
		<table>
			<tr>
				<th><fmt:message key="login.login_message" bundle="${ rb }" /></th>
				<th><fmt:message key="login.password_message" bundle="${ rb }" /></th>
				<th></th>
			</tr>
			<tr>
				<td><input type="email" name="user_name" value="${user_name}" size="30" maxlength="50" required="required"/></td>
				<td><input type="password" name="password" size="25" maxlength="25" pattern="[A-Za-z0-9\\._\\-]{5,20}" required="required" /></td>
				<td><input type="submit" value="<fmt:message key="login.enter" bundle="${ rb }" />" /></td>
			</tr>
		</table>
	</form>
	
	<br>
	<c:if test="${not_valid eq true}"> <fmt:message key="login.not_valid" bundle="${ rb }" />	</c:if>
	<c:if test="${incorrect eq true}"> <fmt:message key="login.incorrect" bundle="${ rb }" /> </c:if>
		
    </body>
</html>