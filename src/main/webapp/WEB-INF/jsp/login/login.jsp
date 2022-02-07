<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<h1>Login</h1>

<form method="POST" action="/login/SecurityPost">
	<label>Username: </label>
	<input type="text" name="username"><br>
	<label>Password: </label>
	<input type="password" name="password"><br>
	<button class="btn btn-secondary" type="submit">Login</button>
</form>

<h4>${invalidCredError}</h4>

<jsp:include page="../include/footer.jsp"/>