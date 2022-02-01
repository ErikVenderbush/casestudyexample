<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../include/header.jsp" />

<form class="form-inline" method="get" action="/registration-url-path/userList">
    <input class="form-control" type="text" name="search">
    <button class="btn btn-secondary" type="submit">Search</button>
</form>

<table class="table table-dark table-striped">
    <thead>
        <tr>
            <th><strong>Id</strong></th>
            <th><strong>Username</strong></th>
            <th><strong>Email</strong></th>
            <th><strong>First Name</strong></th>
            <th><strong>Last Name</strong></th>
            <th><strong>Password</strong></th>
        </tr>
    </thead>
    <c:forEach items="${userListKey}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />