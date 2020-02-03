<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display accounts information</title>
</head>
<body>
Welcome ${user.username }!<br/>
You are ${user.profile }!<br/>


<br/>
<a href="logout">logout</a>
<br/>
<br/>
<br/>
<c:if test="${user.profile == 'mgr'}">
<table border="1">
	<thead>
		<tr>
			<th>account Id</th>
			<th>name</th>
			<th>balance</th>
			<th>account type</th>
			<th>email</th>
			<th>dob</th>
			<th>phone</th>
			<th>address</th>
			<th>delete</th>
			<th>update</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td>${account.accountId}</td>
				<td>${account.name}</td>
				<td>${account.balance}</td>
				<td>${account.accountType}</td>
				<td>${account.email}</td>
				<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${account.dob}" /></td>
				<td>${account.phone}</td>
				<td>${account.address}</td>
				<td><a href="deleteaccount?accountId=${account.accountId}">delete</a></td>
				<td><a href="updateaccount?accountId=${account.accountId}">update</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
<br/>
<a href="addaccount">addaccount</a><br/>
<a href="fundtransfer">transfer money</a><br/>
<a href="depost">depost money</a><br/>
<a href="withdraw">withdraw money</a><br/>
</body>
</html>












