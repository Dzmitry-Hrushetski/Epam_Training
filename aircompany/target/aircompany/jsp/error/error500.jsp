<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
<title><fmt:message key="error.error_page.title" bundle="${ rb }" /></title>
</head>
<body>
	<h3>
		<fmt:message key="aircompany.name" bundle="${ rb }" />
	</h3>

	<p>
    	<b><fmt:message key="error.request_uri" bundle="${ rb }" /></b> 
    	<c:choose>
    	<c:when test="${not empty pageContext.exception}">
    		${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}
    	</c:when>
    	<c:otherwise>
    		${base}
    	</c:otherwise>
    	</c:choose>
    </p>
    <p>
    	<b><fmt:message key="error.request_status" bundle="${ rb }" /></b> 
    	<fmt:message key="error.failed" bundle="${ rb }" />
    </p>
    <p>
    	<b><fmt:message key="error.error_code" bundle="${ rb }" /></b> 
    	<c:choose>
    	<c:when test="${not empty pageContext.exception}">
    		${pageContext.errorData.statusCode}
    	</c:when>
    	<c:otherwise>
    		<fmt:message key="error.500" bundle="${ rb }" />
    	</c:otherwise>
    	</c:choose>
    </p>
    <p>
    	<b><fmt:message key="error.exception" bundle="${ rb }" /></b>
    	<c:choose>
    	<c:when test="${not empty pageContext.exception}">
    		${pageContext.exception}
    	</c:when>
    	<c:otherwise>
    		${requestScope.exception}
    	</c:otherwise>
    	</c:choose>
    </p>
    <p>
    	<b><fmt:message key="error.exception_message" bundle="${ rb }" /></b>
    	<c:choose>
    	<c:when test="${not empty pageContext.exception}">
    		${pageContext.exception.message}
    	</c:when>
    	<c:otherwise>
    		${requestScope.exception.message}
    	</c:otherwise>
    	</c:choose> 
    </p>
	<c:if test="${not empty requestScope.exception}">
	<p>
		<b><fmt:message key="error.exception_cause" bundle="${ rb }" /></b> 
		${requestScope.exception.cause}
	</p>
	</c:if>
    
    <button onclick="history.back()">
    	<fmt:message key="error.back_to_previous" bundle="${ rb }" />
    </button>

	<devtg:develop-info/>
</body>
</html>