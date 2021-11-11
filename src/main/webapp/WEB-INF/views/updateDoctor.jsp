<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<h1 align="center">Редактирование профиля</h1>
<form action="" method="post" modelAttribute="doctorDto">
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
        <tr>
            <td>Опыт:</td>
            <td><input type="text" name="experience" /></td>
        </tr>
	</table>
    <input type="submit" value="Сохранить изменения" />
</form>
<form action="/app/doctor/home" method="get">
    <input type="submit" value="Назад" />
</form>
</body>

</html>