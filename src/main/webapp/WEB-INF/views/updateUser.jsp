<html>

<head>
    <meta charset="UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<%@ page contentType="text/html;charset=utf-8" %>
<h1 align="center">Редактирование профиля</h1>
<form action="" method="post" modelAttribute="user">
    <table>
		<tr>
			<td>Логин:</td>
			<td><input type="text" name="login" /></td>
		</tr>
		<tr>
			<td>Пароль:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
        	<td>ФИО:</td>
        	<td><input type="text" name="name" /></td>
        </tr>
		<tr>
        	<td>Телефон:</td>
        	<td><input type="text" name="number" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" /></td>
        </tr>
	</table>
    <input type="submit" value="Сохранить изменения" />
</form>
<form action="/app/user/${id}" method="get">
    <input type="submit" value="Назад" />
</form>
</body>

</html>