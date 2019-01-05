<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login.jsp</title>
	</head>
	<body>
		<h1>Login画面</h1>

		<s:form action="LoginAction">
			<s:textfield name="username"/>
			<s:password name="password"/>
			<s:submit value="OK"/>
		</s:form>
	</body>
</html>