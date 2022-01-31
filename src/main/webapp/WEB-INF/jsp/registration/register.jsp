<jsp:include page="../include/header.jsp" />

    <form method="GET" action="/registerSubmit">
        <label>Email: </label>
        <input type="email" name="email"><br>
        <label>First Name: </label>
        <input type="text" name="firstName"><br>
        <label>Last Name: </label>
        <input type="text" name="lastName"><br>
        <label>Password: </label>
        <input type="password" name="password"><br>
        <label>Confirm Password: </label>
        <input type="password" name="confirmPassword"><br>
        <button type="submit">Submit</button>
    </form>


<jsp:include page="../include/footer.jsp" />