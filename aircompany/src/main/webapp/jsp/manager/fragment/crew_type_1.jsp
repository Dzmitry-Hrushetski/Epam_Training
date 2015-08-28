<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

	<form action="ControllerServlet" method="post">
				<input type="hidden" name="action" value="manager_command"> 
				<input type="hidden" name="operation" value="crew_entity">
				<input type="hidden" name="route" value="${route}">

		<table>
			<tr>
				<td><fmt:message key="manager.first_pilot" bundle="${ rb }" /></td>
				<td> 
					<select	id="first_pilot" name="first_pilot">
						<c:forEach items="${first_pilot_list}" var="e">
							<option value="${e.id}" ${e.id eq first_pilot ? 'selected' : ''}>${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><fmt:message key="manager.co_pilot" bundle="${ rb }" /></td>
				<td> 
					<select	id="co_pilot" name="co_pilot">
						<c:forEach items="${co_pilot_list}" var="e">
							<option value="${e.id}" ${e.id eq co_pilot ? 'selected' : ''}>${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><fmt:message key="manager.engineer" bundle="${ rb }" /></td>
				<td> 
					<select	id="engineer" name="engineer">
						<c:forEach items="${engineer_list}" var="e">
							<option value="${e.id}" ${e.id eq engineer ? 'selected' : ''}>${e.firstName} ${e.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>

		</table>
				<br>
				<br>
				<c:if test="${not empty delete_state}">
					<fmt:message key="admin.delet_state" bundle="${ rb }" />
				</c:if>
				<c:if test="${not empty save_state}">
					<fmt:message key="admin.save_state" bundle="${ rb }" />
				</c:if>
				<br>
				<br>
				<input type="submit" name="save" value="<fmt:message key="save" bundle="${ rb }" />"  />
				<input type="submit" name="delete" value="<fmt:message key="delete" bundle="${ rb }" />"  />
	</form>
	
