<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
>
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml"
xmlns:fmt="http://java.sun.com/jsp/jstl/fmt">

<fmt:setLocale value="en_EN" scope="session" />
	<fmt:setBundle basename="text" var="rb" />
	
<head>
<title><fmt:message key="login.title" bundle="${ rb }" /></title>
</head>
<body>
<h2><fmt:message key="login.auth_message" bundle="${ rb }" /></h2>
<form action="controller" method="post">
  <table>
    <tr>
       <th>Login</th>
       <th>Password</th>
       <th></th>
      </tr>
    <tr>
       <td><input type="text" value="" name="userName"/></td>
       <td><input type="password" value="" name="password"/></td>
       <td><input type="submit" value="Send" /></td>
      </tr>

  </table>
  
  <input type="email" name="login" size="30" maxlength="50" required="required">
		<br> </br>
		
		<br></br>
		<input type="password" name="password" maxlength="20" size="30"
			pattern="[A-Za-z0-9\\._\\-]{5,20}" required="required"/>
 
  
 </form>

</body>
</html>
</jsp:root>