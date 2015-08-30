<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="devtg" uri="customtags" %>

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
	<p>
	<h4>
		<fmt:message key="cheef.message" bundle="${ rb }" />
	</h4>
	<p/>

	<br>

	<c:if test="${empty position}">
		<c:set var="position" value="1" scope="request" />
	</c:if>

	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="cheef_command"> 
		<input type="hidden" name="operation" value="position"> 
		<label for="position"><fmt:message key="cheef.position_message_list" bundle="${ rb }" /></label> <select id="position" name="position" onchange="submit()">
			<c:forEach items="${position_list}" var="p">
				<option value="${p.id}" ${p.id eq position ? 'selected' : ''}>${p.positionName}</option>
			</c:forEach>
		</select>
	</form>

	<br>

	<c:choose>
		<c:when test="${not empty employee_list}">

			<c:if test="${empty employee}">
				<c:set var="employee" value="1" scope="request" />
			</c:if>

			<form action="ControllerServlet" method="post">	
				<input type="hidden" name="action" value="cheef_command"> 
				<input type="hidden" name="operation" value="employee"> 
				<input type="hidden" name="position" value="${position}"> 
				<label for="employee"><fmt:message key="cheef.employee_message_list" bundle="${ rb }" /></label> 
				<select	id="employee" name="employee" onchange="submit()" >
					<c:forEach items="${employee_list}" var="e">
						<option value="${e.id}" ${e.id eq employee ? 'selected' : ''}>${e.firstName} ${e.lastName}</option>
					</c:forEach>
				</select>
			</form>
		</c:when>
		<c:otherwise>
			<fmt:message key="cheef.employee_message_empty" bundle="${ rb }" />
		</c:otherwise>
	</c:choose>

	<p><fmt:message key="cheef.data" bundle="${ rb }" /></p>
	
	<c:choose>
		<c:when test="${not empty employee_entity}">
			<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="cheef_command"> 
				<input type="hidden" name="operation" value="employee_entity">
				<input type="hidden" name="employee_entity" value="${employee_entity.id}">
				<input type="hidden" name="position" value="${position}">
				<input type="hidden" name="employee" value="${employee}"> 

		<table>
			<tr>
				<td><fmt:message key="cheef.first_name" bundle="${ rb }" /></td>
				<td><input type="text" name="first_name" maxlength="50" value="${employee_entity.firstName}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.last_name" bundle="${ rb }" /></td>
				<td><input type="text" name="last_name" maxlength="50" value="${employee_entity.lastName}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.phone" bundle="${ rb }" /></td>
				<td><input type="text" name="phone" maxlength="13" value="${employee_entity.phone}" required="required" pattern="\+375[0-9]{9}"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.addres" bundle="${ rb }" /></td>
				<td><input type="text" name="addres" size="50" maxlength="80" value="${employee_entity.addres}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.user_name" bundle="${ rb }" /></td>
				<td><input type="email" name="user_name" size="30" maxlength="50" value="${employee_entity.userName}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.password" bundle="${ rb }" /></td>
				<td><input type="text" name="password" maxlength="25" value="${employee_entity.password}" required="required" pattern="[A-Za-z0-9\\._\\-]{5,20}"/></td>
			</tr>
			<tr>
				<td><fmt:message key="cheef.date" bundle="${ rb }" /></td>
				<td><input type="date" name="calendar" value="<devtg:date calendar="${employee_entity.startDate}"/>" required="required"/></td>
			</tr>
		</table>
				<br>
				<br>
				<c:if test="${not empty delete_state}">
					<fmt:message key="cheef.delet_state" bundle="${ rb }" />
				</c:if>
				<c:if test="${not empty save_state}">
					<fmt:message key="cheef.save_state" bundle="${ rb }" />
				</c:if>
				<c:if test="${not empty bad_data}">
					<fmt:message key="cheef.bad_data" bundle="${ rb }" />
				</c:if>
				<br>
				<br>
				<input type="submit" name="save" value="<fmt:message key="save" bundle="${ rb }" />"  />
				<input type="submit" name="delete" value="<fmt:message key="delete" bundle="${ rb }" />"  />
			</form>
		</c:when>

	</c:choose>
	
	<br>
	
	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="cheef_command">
		<input type="hidden" name="operation" value="create_new">
		<input type="hidden" name="position" value="${position}"> 
		<input type="submit" name="create" value="<fmt:message key="cheef.create" bundle="${ rb }" />"  />
	</form>
	
	<br>
	
	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="logout_command">
		<input type="submit" name="logout" value="<fmt:message key="logout" bundle="${ rb }" />"  />
	</form>
	
	<devtg:develop-info/>
</body>
</html>