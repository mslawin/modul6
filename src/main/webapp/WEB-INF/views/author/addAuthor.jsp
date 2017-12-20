<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add book</title>
</head>
<body>
<p>Add author</p>
	<form:form method="post" modelAttribute="author">
		First namne<form:input path="firstName" type="text"/> <form:errors path="firstName" /> <br />
		Last name<form:input path="lastName" type="text" /> <form:errors path="lastName" /> <br />
		
		Email<form:input path="email" /> <form:errors path="email" /> <br />
		Pesel<form:input path="pesel" /> <form:errors path="pesel" /> <br />
		Year of birth<form:input path="yearOfBirth" type="number"/> <form:errors path="yearOfBirth" /><br />
		<input type='submit' /><br />
	</form:form>
${author}<br/>

</body>
</html>