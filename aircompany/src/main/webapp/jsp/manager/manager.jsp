<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="devtg" uri="customtags" %>

<c:set var="user_type" value="manager" scope="session"/>

<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="text" var="rb" />

<!DOCTYPE html>

<html lang="${locale}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='css/style.css' type='text/css' />
<title><fmt:message key="manager.title" bundle="${ rb }" /></title>
</head>
<body>
	<h3>
		<fmt:message key="aircompany.name" bundle="${ rb }" />
	</h3>
	<p>
	<h4>
		<fmt:message key="manager.message" bundle="${ rb }" />
	</h4>
	<p/>

	<br>

	<c:if test="${empty route}">
		<c:set var="route" value="1" scope="request" />
	</c:if>

	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="manager_command"> 
		<input type="hidden" name="operation" value="route"> 
		<label for="route"><fmt:message key="admin.route_list_message" bundle="${ rb }" /></label>
		 <select id="route" name="route" onchange="submit()">
			<c:forEach items="${route_list}" var="p">
				<option value="${p.id}" ${p.id eq route ? 'selected' : ''}>${p.routeNumber} ${p.departureAirport.city.cityName} - ${p.arrivalAirport.city.cityName} ${p.airplane.airplaneType.modelName}</option>
			</c:forEach>
		</select>
	</form>

	<br>
	
	<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="manager_command"> 
				<input type="hidden" name="operation" value="crew_entity">
				<input type="hidden" name="route" value="${route}">
				
		<table>
			<tr>
				<td><fmt:message key="manager.first_pilot" bundle="${ rb }" /></td>
				<td> 
					* <select	id="first_pilot" name="first_pilot" required>
						<option value="" ><fmt:message key="manager.first_pilot_select" bundle="${ rb }" /></option>
						<c:forEach items="${first_pilot_list}" var="e">
							<option value="${e.id}" >${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		
			<c:if test="${not empty co_pilot_present}">
					
			<tr>
				<td><fmt:message key="manager.co_pilot" bundle="${ rb }" /></td>
				<td> 
					* <select	id="co_pilot" name="co_pilot" required>
						<option value="" ><fmt:message key="manager.co_pilot_select" bundle="${ rb }" /></option>
						<c:forEach items="${co_pilot_list}" var="e">
							<option value="${e.id}" >${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			</c:if>
			
			<c:if test="${not empty engineer_present}">
			<tr>
				<td><fmt:message key="manager.engineer" bundle="${ rb }" /></td>
				<td> 
					* <select	id="engineer" name="engineer" required>
						<option value="" ><fmt:message key="manager.engineer_select" bundle="${ rb }" /></option>
						<c:forEach items="${engineer_list}" var="e">
							<option value="${e.id}" >${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			</c:if>
			
			<c:if test="${not empty navigator_present}">
			<tr>
				<td><fmt:message key="manager.navigator" bundle="${ rb }" /></td>
				<td> 
					* <select	id="navigator" name="navigator" required>
						<option value="" ><fmt:message key="manager.navigator_select" bundle="${ rb }" /></option>
						<c:forEach items="${navigator_list}" var="e">
							<option value="${e.id}" >${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			</c:if>
			
			<c:if test="${not empty steward_present}">
			<tr>
				<td><fmt:message key="manager.steward" bundle="${ rb }" /></td>
				<td> 
					* <select	id="steward" name="steward" size="8" multiple required>
						<option value="" ><fmt:message key="manager.steward_select" bundle="${ rb }" /></option>
						<c:forEach items="${steward_list}" var="e">
							<option value="${e.id}" >${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			</c:if>
		
		</table>
				<br>
				<br>
				<c:if test="${not empty delete_state}">
					<fmt:message key="manager.delet_state" bundle="${ rb }" />
				</c:if>
				<c:if test="${not empty save_state}">
					<fmt:message key="manager.save_state" bundle="${ rb }" />
				</c:if>
				<c:if test="${not empty bad_data}">
					<fmt:message key="manager.bad_data" bundle="${ rb }" />
					<c:out value="${stewards_count}" />
				</c:if>
				<br>
				<br>
				<input type="submit" name="save" value="<fmt:message key="save" bundle="${ rb }" />"  />
				<br>	
	</form>
	<c:if test="${not empty crew}">
	<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="manager_command"> 
				<input type="hidden" name="operation" value="crew_entity">
				<input type="hidden" name="route" value="${route}">
				<input type="submit" name="delete" value="<fmt:message key="delete" bundle="${ rb }" />"  />
	</form>
	</c:if>
	<br>
	<fmt:message key="manager.crew_list" bundle="${ rb }" />
	<br>
	<c:choose>
		<c:when test="${not empty crew}"> 
			<c:forEach items="${crew.crew}" var="e">
				<p>${e.position.positionName}: ${e.firstName} ${e.lastName}</p>
			</c:forEach>
		</c:when>
		
		<c:otherwise> 
			<fmt:message key="manager.crew_list_empty" bundle="${ rb }" />
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	
	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="logout_command">
		<input type="submit" name="logout" value="<fmt:message key="logout" bundle="${ rb }" />"  />
	</form>
	<devtg:develop-info/>
</body>
</html>