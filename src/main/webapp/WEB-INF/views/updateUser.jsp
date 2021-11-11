<html>

<head>
    <meta charset="UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<%@ page contentType="text/html;charset=utf-8" %>
<h1 align="center">Редактирование профиля</h1>
<form action="" method="post" modelAttribute="userDto">
    <table>
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
<form action="/app/user/home" method="get">
    <input type="submit" value="Назад" />
</form>
</body>

</html>