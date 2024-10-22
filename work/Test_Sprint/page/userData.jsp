<!DOCTYPE html>
<html>
<head>
    <title>User Data</title>
</head>
<body>
    <h2>Welcome, ${username}</h2>
    <p>Your data:</p>
    <ul>
        <c:forEach var="item" items="${data}">
            <li>${item}</li>
        </c:forEach>
    </ul>
    <form action="logout" method="post">
        <button type="submit">Logout</button>
    </form>
</body>
</html>
