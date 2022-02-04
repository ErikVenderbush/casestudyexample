<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<h1>Index</h1>

<form method="get" action="/indexSubmit">
	<label>Username</label>
	<input type="text" name="username"><br>
	<label>First Name</label>
	<input type="text" name="firstName"><br>
	<label>Dropdown</label>
	<select type="text" name="dropdown">
		<option>Option 1</option>
		<option>Option 2</option>
		<option>Option 3</option>
	</select><br>
	<button type="submit">Login</button>
</form>

<jsp:include page="../include/footer.jsp"/>