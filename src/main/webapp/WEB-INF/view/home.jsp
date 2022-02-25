<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web Security Demo</title>
</head>

<body>
    <h1>HAA Enterprises Home Page</h1>
    <hr>
    <p>Welcome to HAA Enterprises home page. Comming soon...</p>

    <hr>
    <p>
        User:
        <security:authentication property="principal.username" />

        <br><br>
        Role(s):
        <security:authentication property="principal.authorities" />

    </p>
    <hr>
    <p>
        <a href="leaders">Leadership Meeting</a>
        (Only for Manager Peeps)
    </p>
    <p>
        <a href="systems">IT Systems Meeting</a>
        (Only for Admin Peeps)
    </p>
    <hr>

    <form:form action="logout" method="POST">
        <input type="submit" value="Logout">
    </form:form>
</body>

</html>