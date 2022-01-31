<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/header.jsp" />

    <h1>Login</h1>

    <form method="get" action="/loginSubmit2">
        <label>Username: </label>
        <input type="text" name="usernameFromForm"><br>
        <label>Password: </label>
        <input type="password" name="passwordFromForm"><br>
        <button type="submit">Login</button>
    </form>

    <h4>${invalidCredError}</h4>

<jsp:include page="../include/footer.jsp" />