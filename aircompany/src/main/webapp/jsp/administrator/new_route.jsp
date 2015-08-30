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
<title><fmt:message key="admin.title" bundle="${ rb }" /></title>
</head>
<body>
	<h3>
		<fmt:message key="aircompany.name" bundle="${ rb }" />
	</h3>
	<p>
	<h4>
		<fmt:message key="admin.new.message" bundle="${ rb }" />
	</h4>
	<p/>

	<br>
<!-- 
	<c:if test="${empty route}">
		<c:set var="route" value="1" scope="request" />
	</c:if>

	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="admin_command"> 
		<input type="hidden" name="operation" value="route"> 
		<label for="route"><fmt:message key="admin.route_list_message" bundle="${ rb }" /></label>
		 <select id="route" name="route" onchange="submit()">
			<c:forEach items="${route_list}" var="p">
				<option value="${p.id}" ${p.id eq route ? 'selected' : ''}>${p.routeNumber} ${p.departureAirport.city.cityName} - ${p.arrivalAirport.city.cityName}</option>
			</c:forEach>
		</select>
	</form>

	<br>
 -->
		
	
		<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="new_route_command"> 
				<input type="hidden" name="operation" value="new_route_entity">
				
		<table>
			<tr>
				<td><fmt:message key="admin.departure_airport" bundle="${ rb }" /></td>
				<td> 
					<select	id="departure_airport" name="departure_airport">
						<c:forEach items="${departure_airport_list}" var="p">
							<option value="${p.id}" ${p.id eq route_entity.departureAirport.id ? 'selected' : ''}>${p.city.cityName} ${p.airportName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><fmt:message key="admin.arrival_airport" bundle="${ rb }" /></td>
				<td> 
					<select	id="arrival_airport" name="arrival_airport">
						<c:forEach items="${arrival_airport_list}" var="p">
							<option value="${p.id}" ${p.id eq route_entity.arrivalAirport.id ? 'selected' : ''}>${p.city.cityName} ${p.airportName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><fmt:message key="admin.airplane" bundle="${ rb }" /></td>
				<td> 
					<select	id="airplane" name="airplane">
						<c:forEach items="${airplane_list}" var="a">
							<option value="${a.id}" ${a.id eq route_entity.airplane.id ? 'selected' : ''}>${a.airplaneType.modelName} ${a.boardNumber}</option>
						</c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td><fmt:message key="admin.route_number" bundle="${ rb }" /></td>
				<td><input type="text" name="route_number" maxlength="25" value="${route_entity.routeNumber}" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.departure_time" bundle="${ rb }" /></td>
				<td><input type="datetime" name="departure_time" value="<devtg:date-time calendar="${route_entity.departure}"/>" required="required"/></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.arrival_time" bundle="${ rb }" /></td>
				<td><input type="datetime" name="arrival_time" value="<devtg:date-time calendar="${route_entity.arrival}"/>" required="required"/></td>
			</tr>
		</table>
				<br>
				<br>
				<c:if test="${not empty save_state}">
					<fmt:message key="admin.save_state" bundle="${ rb }" />
				</c:if>
				<br>
				<br>
				<input type="submit" name="save" value="<fmt:message key="save" bundle="${ rb }" />"  />
				
		</form>
		<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="new_route_command"> 
				<input type="hidden" name="operation" value="back">
				<input type="submit" name="back" value="<fmt:message key="cheef.back" bundle="${ rb }" />"  />
		</form>
	
	<br>
	<br>
	
	<form action="ControllerServlet" method="post">
		<input type="hidden" name="action" value="logout_command">
		<input type="submit" name="logout" value="<fmt:message key="logout" bundle="${ rb }" />"  />
	</form>
	
	<devtg:develop-info/>
</body>
</html>