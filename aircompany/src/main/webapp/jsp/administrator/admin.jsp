<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="text" var="rb" />

<!DOCTYPE html>

<html lang="${locale}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="admin.title" bundle="${ rb }" /></title>
</head>
<body>
	<h3>
		<fmt:message key="aircompany.name" bundle="${ rb }" />
	</h3>
	<p>
	<h4>
		<fmt:message key="admin.message" bundle="${ rb }" />
	</h4>
	<p/>

	<br>

	<c:if test="${empty position}">
		<c:set var="route" value="1" scope="request" />
	</c:if>

	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="admin_command"> 
		<input type="hidden" name="operation" value="route"> 
		<label for="route"><fmt:message key="admin.route_list_message" bundle="${ rb }" /></label> <select id="route" name="route" onchange="submit()">
			<c:forEach items="${route_list}" var="p">
				<option value="${p.id}" ${p.id eq route ? 'selected' : ''}>${p.routeNumber} ${p.departureAirport.city.cityName} - ${p.arrivalAirport.city.cityName}</option>
			</c:forEach>
		</select>
	</form>

	<br>

		
	<c:choose>
		<c:when test="${not empty route_entity}">
			<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="admin_command"> 
				<input type="hidden" name="operation" value="route_entity">
				<input type="hidden" name="route_entity" value="${route_entity.id}">
				<input type="hidden" name="route" value="${route}">

		<table>
			<tr>
				<td><fmt:message key="admin.route_number" bundle="${ rb }" /></td>
				<td><input type="text" name="route_number" maxlength="25" value="${route_entity.routeNumber}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.departure_time" bundle="${ rb }" /></td>
				<td><input type="datetime" name="departure_time" value="${route_entity.departureString}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.arrival_time" bundle="${ rb }" /></td>
				<td><input type="datetime" name="arrival_time" maxlength="13" value="${route_entity.arrivalString}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.arrival_time" bundle="${ rb }" /></td>
				<td><input type="datetime" name="arrival_time" value="2004-07-24 18:18:18" required="required"/></td>
			</tr>
			<!-- 
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
				<td><input type="date" name="calendar" value="${employee_entity.startDateString}" required="required"/></td>
			</tr>
			 -->
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
				<input type="submit" name="save" value="<fmt:message key="cheef.save" bundle="${ rb }" />"  />
				<input type="submit" name="delete" value="<fmt:message key="cheef.delete" bundle="${ rb }" />"  />
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
		<input type="submit" name="logout" value="<fmt:message key="cheef.logout" bundle="${ rb }" />"  />
	</form>
	
</body>
</html>