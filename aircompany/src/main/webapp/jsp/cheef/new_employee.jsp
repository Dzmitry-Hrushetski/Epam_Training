<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="devtg" uri="customtags" %>

<c:set var="user_type" value="cheef" scope="session"/>

<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="text" var="rb" />

<!DOCTYPE html>

<html lang="${locale}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='css/style.css' type='text/css' />
<title><fmt:message key="cheef.title" bundle="${ rb }" /></title>
</head>
<body>
	<h3>
		<fmt:message key="aircompany.name" bundle="${ rb }" />
	</h3>
	<p>
	<h4>
		<fmt:message key="cheef.new.message" bundle="${ rb }" />
	</h4>
	<p/>


	<c:if test="${empty position}">
		<c:set var="position" value="1" scope="request" />
	</c:if>

	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="create_employee_command"> 
		<input type="hidden" name="operation" value="position"> 
		<label for="position"><fmt:message key="cheef.position_message_list" bundle="${ rb }" /></label> <select id="position" name="position" onchange="submit()">
			<c:forEach items="${position_list}" var="p">
				<option value="${p.id}" ${p.id eq position ? 'selected' : ''}>${p.positionName}</option>
			</c:forEach>
		</select>
	</form>

	<p><fmt:message key="cheef.data" bundle="${ rb }" /></p>
	
	<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="create_employee_command"> 
				<input type="hidden" name="operation" value="employee_entity">
				<input type="hidden" name="position" value="${position}"> 
		<table>
			<tr>
				<td><fmt:message key="cheef.first_name" bundle="${ rb }" /></td>
				<td>* <input type="text" name="first_name" maxlength="50" value="${first_name}" required="required" title="50 <fmt:message key="chif.lenght.title" bundle="${ rb }" />"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.last_name" bundle="${ rb }" /></td>
				<td>* <input type="text" name="last_name" maxlength="50" value="${last_name}" required="required" title="50 <fmt:message key="chif.lenght.title" bundle="${ rb }" />"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.phone" bundle="${ rb }" /></td>
				<td>* <input type="text" name="phone" maxlength="13" value="${phone}" required="required" pattern="\+375[0-9]{9}" title="<fmt:message key="chif.phone.title" bundle="${ rb }" />"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.addres" bundle="${ rb }" /></td>
				<td>* <input type="text" name="addres" size="50" maxlength="80" value="${addres}" required="required" title="80 <fmt:message key="chif.lenght.title" bundle="${ rb }" />"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.user_name" bundle="${ rb }" /></td>
				<td>* <input type="email" name="user_name" size="30" maxlength="50" value="${user_name}" required="required"/></td>
				<!-- ${position eq 1 ? 'required="required"' : ''} -->
			</tr>
			<tr>
				<td><fmt:message key="cheef.password" bundle="${ rb }" /></td>
				<td>* <input type="text" name="password" maxlength="25" value="${password}" required="required" pattern="[A-Za-z0-9\\._\\-]{5,20}" title="<fmt:message key="login.title" bundle="${ rb }" />"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.date" bundle="${ rb }" /></td>
				<td>* <input type="date" name="calendar" value="${calendar}" required="required" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"/></td>
			</tr>
		</table>
				<br>
				<br>
				<c:if test="${not empty save_state}">
					<fmt:message key="cheef.save_state" bundle="${ rb }" />
				</c:if>
				<c:if test="${not empty bad_data}">
					<fmt:message key="cheef.bad_data" bundle="${ rb }" />
				</c:if>
				<br>
				<br>
				<input type="submit" name="save" value="<fmt:message key="save" bundle="${ rb }" />"  />
			</form>
			<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="create_employee_command"> 
				<input type="hidden" name="operation" value="back">
				<input type="submit" name="back" value="<fmt:message key="cheef.back" bundle="${ rb }" />"  />
		</form>
	
	<br>
	
	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="logout_command">
		<input type="submit" name="logout" value="<fmt:message key="logout" bundle="${ rb }" />"  />
	</form>
	
	<devtg:develop-info/>
</body>
</html>