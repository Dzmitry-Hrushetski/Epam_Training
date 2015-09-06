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
<link rel='stylesheet' href='css/style.css' type='text/css' />
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
		<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="new_route_command"> 
				<input type="hidden" name="operation" value="new_route_entity">
				
		<table>
			<tr>
				<td><fmt:message key="admin.departure_airport" bundle="${ rb }" /></td>
				<td> 
					* <select	id="departure_airport" name="departure_airport">
						<c:forEach items="${departure_airport_list}" var="p">
							<option value="${p.id}" ${p.id eq route_entity.departureAirport.id ? 'selected' : ''}>${p.city.cityName} ${p.airportName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><fmt:message key="admin.arrival_airport" bundle="${ rb }" /></td>
				<td> 
					* <select	id="arrival_airport" name="arrival_airport">
						<c:forEach items="${arrival_airport_list}" var="p">
							<option value="${p.id}" ${p.id eq route_entity.arrivalAirport.id ? 'selected' : ''}>${p.city.cityName} ${p.airportName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><fmt:message key="admin.airplane" bundle="${ rb }" /></td>
				<td> 
					* <select	id="airplane" name="airplane">
						<c:forEach items="${airplane_list}" var="a">
							<option value="${a.id}" ${a.id eq route_entity.airplane.id ? 'selected' : ''}>${a.airplaneType.modelName} ${a.boardNumber}</option>
						</c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td><fmt:message key="admin.route_number" bundle="${ rb }" /></td>
				<td>* <input type="text" name="route_number" maxlength="25" required="required" pattern="[A-Za-z0-9\\._\\-]{4,8}" title="<fmt:message key="admin.route.title" bundle="${ rb }" />"/></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.departure_time" bundle="${ rb }" /></td>
				<td>* <input type="datetime" name="departure_time" value="<fmt:message key="admin.date.title" bundle="${ rb }" />" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01]) (([0-1][0-9])|2[0-3]):([0-5][0-9]):([0-5][0-9])" required="required" title="<fmt:message key="admin.date.title" bundle="${ rb }" />"/></td>
			</tr>
			<tr>
				<td><fmt:message key="admin.arrival_time" bundle="${ rb }" /></td>
				<td>* <input type="datetime" name="arrival_time" value="<fmt:message key="admin.date.title" bundle="${ rb }" />" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01]) (([0-1][0-9])|2[0-3]):([0-5][0-9]):([0-5][0-9])" required="required" title="<fmt:message key="admin.date.title" bundle="${ rb }" />"/></td>
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