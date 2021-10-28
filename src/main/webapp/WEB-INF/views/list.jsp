<html>

<head>
    <meta charset="UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<div align="center">
    <%@ page contentType="text/html;charset=utf-8" %>
    <h1>Список всех пользователей:</h1>
    <p>"${list}"</p>
    <hr>
    <form action="/app/user/${id}" method="get">
            <input type="submit" value="Назад" />
    </form>
</div>

</body>
</html>