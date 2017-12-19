<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Person add form</title>
</head>
<body>
	<form method='post'>
		<label for='login'>Login</label>
		<input type='text' name='login'	id='login' /><br />
	    Password<input type='password' name='password' /><br />
		Email<input type='email' name='email' /><br />
		<input type='submit' />
	</form>
	${text}<br/>
</body>
</html>