<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Person add form taglib</title>
</head>
<body>
<p>Person add form taglib</p>
	<form:form method="post" modelAttribute="person">
		<form:label path="login">Login</form:label>
		<form:input path="login" type="text"/><br />
		<form:password path="password" /><br />
		<form:input path="email" type="email" /><br />
		<form:textarea path="personDetails.details" />
		<input type='submit' />
	</form:form>
${person}<br/>

</body>
</html>