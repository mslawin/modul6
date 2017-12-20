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
<p>Add book</p>
	<form:form method="post" modelAttribute="book">
		Title<form:input path="title" type="text"/> <form:errors path="title" /> <br />
		<form:select path="authors" multiple="true">
			<form:options items="${availableAuthors}"
			              itemValue="id"
			              itemLabel="fullName"/>
		</form:select> <form:errors path="authors" />  <br />
		<form:input path="rating" type="number" /> <form:errors path="rating" /> <br />
		
		<form:select path="publisher">
			<form:options items="${availablePublishers}"
			              itemValue="id"
			              itemLabel="name"/>
		</form:select> <form:errors path="publisher" />  <br />
		<form:textarea path="description" /> <form:errors path="description" /> <br />
		<form:input path="pages" /> <form:errors path="pages" /> <br />
		<input type='submit' /><br />
	</form:form>
${book}<br/>

</body>
</html>