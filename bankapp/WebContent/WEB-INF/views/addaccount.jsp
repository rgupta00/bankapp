<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add/update account</title>
</head>
<body>
<form:form action="addaccount" method="post" modelAttribute="account">
	 Enter name : <form:input path="name"/><br/>
	 Enter balance : <form:input path="balance"/><br/>
	 Enter accountType : <form:select path="AccountType" items="${accountTypes}"/><br/>
	 Enter dob : <form:input path="dob"/><br/>
	 Enter email : <form:input path="email"/><br/>
	 Enter phone : <form:input path="phone"/><br/>
	 Enter address : <form:input path="address"/><br/>
	 <input type="submit"/>
</form:form>
</body>
</html>