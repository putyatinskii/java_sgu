<html>
<body>
<div align="center">
<h1>Вход в аккаунт</h1>
<%@ page contentType="text/html;charset=utf-8" %>
<form action="sign-in/" method="post">
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
			<td>Отметьте поле, если вы доктор</td>
			<td><input type="checkbox" name="isDoctor" value="isDoctor"></td>
		</tr>
	</table>
	<input type="submit" value="Войти" />
</form>
<form action="start" method="get">
    <input type="submit" value="На главную" />
</form>
</div>
</body>
</html>