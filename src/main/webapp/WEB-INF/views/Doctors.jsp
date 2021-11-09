<html>

<head>
    <meta charset="UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<div align="center">
    <%@ page contentType="text/html;charset=utf-8" %>
    <h1>Список всех врачей:</h1>
    <p>"${list}"</p>
    <hr>
    <form action="/app/doctor/${id}" method="get">
            <input type="submit" value="Назад" />
    </form>
</div>

</body>
</html>