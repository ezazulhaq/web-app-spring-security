<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Custom Login Page</title>

    <style>
        .failed {
            color: red;
        }
    </style>
</head>

<body>
    <h3>My Custom Login Page</h3>
    <form:form action="authenticateTheUser" method="POST">

        <c:if test="${param.error != null}">
            <em class="failed">
                Sorry!! You have Entered invalid username/password
            </em>
        </c:if>

        <p>
            UserName: <input type="text" name="username">
        </p>
        <p>
            Password: <input type="password" name="password">
        </p>

        <input type="submit" value="Login" />
    </form:form>
</body>

</html>