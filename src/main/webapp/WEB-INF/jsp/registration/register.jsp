<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<form method="GET" action="/registration-url-path/registerSubmit">
	
	<h1>Register</h1>
	
	<input type="hidden" name="id" value="${formBeanKey.id}">
	
	<table cellpadding="5">
		<tr>
			<td>Username</td>
			<td><input type="text" name="username" value="${formBeanKey.username}"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="${formBeanKey.email}"></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="firstName" value="${formBeanKey.firstName}"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lastName" value="${formBeanKey.lastName}"></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="number" name="age" value="${formBeanKey.age}"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				<input type="password" name="password" value="${formBeanKey.password}"></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><input type="password" name="confirmPassword" value="${formBeanKey.confirmPassword}"></td>
		</tr>
	</table>
	
	<button class="btn btn-secondary" type="submit">Submit</button>

</form>

<div>
	<c:forEach items="${formBeanKey.errorMessages}" var="message">
		<span style="color: red">${message}</span><br>
	</c:forEach>
</div>

<jsp:include page="../include/footer.jsp"/>