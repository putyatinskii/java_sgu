<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<h1 align="center">Заполните информацию о себе</h1>
<c:if test="${param.error != null}">
    <p>Логин, телефон и почта должны быть уникальными</p>
</c:if>
<form action="doctor-sign-up" method="post" modelAttribute="doctorDto">
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
        <tr>
            <td>Специальность:</td>
            <td>
<select name="speciality" id="speciality">
    <option value=""></option>
        <c:forEach items="${speciality}" var="option">
                <option value="${option}">
                    <c:out value="${option.speciality}"></c:out>
                </option>
        </c:forEach>
</select>
            </td>
        </tr>
        <tr>
            <td>Стаж:</td>
            <td><input type="text" name="experience" /></td>
        </tr>
	</table>
    <input type="submit" value="Зарегистрироваться" />
</body>

</html>