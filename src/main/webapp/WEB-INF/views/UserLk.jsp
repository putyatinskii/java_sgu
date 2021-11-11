<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<div align="center">
    <%@ page contentType="text/html;charset=utf-8" %>
    <h1>Личный кабинет пользователя</h1>
    <p>ФИО: "${name}"</p>
    <p>Логин: "${login}"</p>
    <p>Телефон: "${phone}"</p>
    <p>Эл. почта: "${email}"</p>
    <form action="/app/user/home/all" method="get">
        <input type="submit" value="Посмотреть список всех пользователей" />
    </form>
    <form action="/app/user/home/update" method="get">
        <input type="submit" value="Отредактировать информацию о себе" />
    </form>
    <form action="/app/user/home" method="post">
        <input type="submit" value="Удалить пользователя" />
    </form>
    <form action="/app/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Выйти" />
    </form>
</div>
</body>
</html>