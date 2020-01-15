<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 15.01.2020
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <table>
        <form:form method="post" action="signUp" modelAttribute="user">
        <tr>
            <td>
                <form:label path="mail">Email</form:label>
                <form:input path="mail"/>
            </td>
            <td>
                <form:label path="name">Name</form:label>
                <form:input path="name"/>
            </td>
            <td>
                <form:label path="password">Password</form:label>
                <form:input path="password"/>
            </td>
        </tr>
            <input type="submit" value="Зарегестрироваться"/>
        </form:form>
        <form:form action="login" method="get">
            <input type="submit" value="Вернуться"/>
        </form:form>
    </table>
</body>
</html>
