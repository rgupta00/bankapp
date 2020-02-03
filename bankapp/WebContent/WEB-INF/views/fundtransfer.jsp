<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fund transfer page</title>
<style>
.error {
color: #EF1313;
font-style: italic;
}
</style>
</head>
<body>
<form:form action="fundtransfer" method="post" modelAttribute="transferForm">
	 Enter from Account : <form:input path="fromAccountId"/><form:errors path="fromAccountId" class="error"/><br/>
	 Enter to Account : <form:input path="toAccountId"/><form:errors path="toAccountId" class="error"/><br/>
	 Enter amount :<form:input path="amount"/><form:errors path="amount" class="error"/><br/>
	 <input type="submit"/>
</form:form>
</body>
</html>